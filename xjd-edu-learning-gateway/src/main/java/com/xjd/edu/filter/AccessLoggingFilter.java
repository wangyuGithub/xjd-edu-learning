package com.xjd.edu.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.concurrent.atomic.AtomicLong;

import static com.xjd.edu.config.AppConfig.X_REQUEST_ID;
import static com.xjd.edu.utils.WebHelper.getLoginToken;
import static com.xjd.edu.utils.WebHelper.getRequestId;


/**
 * 访问日志过滤器，仅用于记录日志、监控，不作其它任何业务逻辑控制
 *
 * @author zlikun
 * @since 2023/1/13
 */
@Slf4j
@Component
public class AccessLoggingFilter implements GlobalFilter, Ordered {

    @Autowired
    private StandardEnvironment environment;

    /**
     * 默认抽样率（百分数）
     */
    private static final int DEFAULT_SAMPLE_RATE = 100;

    /**
     * 请求计数器
     */
    private static final AtomicLong counter = new AtomicLong();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        final String requestId = getRequestId(exchange.getRequest());
        exchange.getAttributes().put(X_REQUEST_ID, requestId);

        final MDC.MDCCloseable closeable = MDC.putCloseable(X_REQUEST_ID, requestId);
        final boolean isDisplay = isDisplay(counter.incrementAndGet());

        final String traceId = exchange.getRequest().getId();
        final long begin = System.currentTimeMillis();

        // 控制日志采样率，避免访问日志过多对系统造成影响
        if (isDisplay) {
            log.info("request_chain_begin traceId: {}, path: {}, query: {}, token: {}",
                    traceId,
                    exchange.getRequest().getURI().getPath(),
                    exchange.getRequest().getURI().getQuery(),
                    getLoginToken(exchange.getRequest()));
            //exchange.getAttributes().put(CHAIN_LOGGING_ALLOW_KEY, ENABLE);
        } else {
            // 全局入站日志还是要打印出来，方便排查问题
            log.info("gateway route request, path: {}, token: {}",
                    exchange.getRequest().getURI().getPath(),
                    getLoginToken(exchange.getRequest()));
        }

        return chain.filter(exchange)
                .doFinally(st -> {
                    if (isDisplay) {
                        if (st == SignalType.ON_ERROR) {
                            log.warn("request_chain_error traceId: {}, elapsed: {} ms", traceId, System.currentTimeMillis() - begin);
                        } else {
                            log.info("request_chain_end traceId: {}, elapsed: {} ms", traceId, System.currentTimeMillis() - begin);
                        }
                    }

                    closeable.close();
                });
    }

    /**
     * 是否打印日志
     *
     * @param number 请求计数
     * @return
     */
    private boolean isDisplay(long number) {
        // 取值范围 [0, 100]，小于0取0表示完全不打印，大于100取100表示全部打印
        final int sampleRate = Math.min(Math.max(environment.getProperty("biz.logging.chain_sample_rate", Integer.class, DEFAULT_SAMPLE_RATE), 0), 100);
        // 完全不打印
        if (sampleRate == 0) {
            return false;
        }
        // 全部打印
        if (sampleRate == 100) {
            return true;
        }
        // 按抽样率返回，例：20 （20%），表示每100个请求中20个返回true
        // 将请求计数转换为100以内的数值，从中抽取 20% 返回 true，这里简单取数值前sampleRate个请求返回（暂不做正态分布算法）
        return number % 100 < sampleRate;
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }

}
