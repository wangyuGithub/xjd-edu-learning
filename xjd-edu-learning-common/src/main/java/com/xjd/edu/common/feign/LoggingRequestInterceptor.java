package com.xjd.edu.common.feign;

import com.xjd.edu.common.utils.UuidUtil;
import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static com.xjd.edu.common.Constant.CHAIN_LOGGING_ALLOW_KEY;
import static com.xjd.edu.common.constant.HeaderConstant.*;
import static com.xjd.edu.common.feign.FeignCountMeterEnvironmentChangeEventListener.ALLOW_COUNT_PATH_KEY;
import static com.xjd.edu.common.feign.FeignCountMeterEnvironmentChangeEventListener.METER_ID_NAME;
import static com.xjd.edu.common.constant.HeaderConstant.X_REQUEST_ID;
import static com.xjd.edu.common.constant.HeaderConstant.X_REQUEST_URI;

/**
 * 日志拦截器（OpenFeign）
 * https://docs.spring.io/spring-cloud-openfeign/docs/2.2.8.RELEASE/reference/html/
 *
 * @author zlikun
 * @date 2021/06/07 18:48
 */
@Slf4j
@Component
@ConditionalOnClass(Feign.class)
@ConditionalOnProperty(name = "feign.logging.enable", matchIfMissing = true)
public class LoggingRequestInterceptor implements RequestInterceptor {

    @Autowired
    private StandardEnvironment environment;

    @Autowired
    private MeterRegistry registry;

    @Override
    public void apply(RequestTemplate rt) {
        // 将MDC中的 X-Request-Id 添加到请求消息头
        String requestId = MDC.get(X_REQUEST_ID);
        MDC.MDCCloseable mdc = null;
        // 如果上游不传则自己生成（局部可追溯好过无法追溯）
        if (StringUtils.isBlank(requestId)) {
            requestId = "feign_" + UuidUtil.uuid();
            mdc = MDC.putCloseable(X_REQUEST_ID, requestId);
        }

        // 向服务提供者传递 X-Request-Id 消息头
        rt.header(X_REQUEST_ID, requestId);

        // 向服务提供者传递 upstream 信息
        final String upstream = MDC.get(X_REQUEST_URI);
        if (StringUtils.isNotBlank(upstream)) {
            rt.header(X_REQUEST_URI, upstream);
        }

        // 记录调用日志
        if (log.isDebugEnabled()) {
            log.debug("$FEIGN request: {}", rt.url());
        }

        // 解决串号的问题，这里实际只对自生成的串号有作用，本质上Feign拦截器是有一个前置拦截器不能真在这个里把MDC清空掉，否则后面的日志就没有串号了
        if (mdc != null) {
            mdc.close();
        }

        // 生成计数统计
        try {
            this.metrics(upstream, rt.path());
        } catch (Exception e) {
            log.error("请求 {} -> {} 监控计数出错", upstream, rt.path(), e);
        }
    }

    /**
     * 记录请求上下游监控计数
     *
     * @param from 请求上游
     * @param to   请求下游
     */
    private void metrics(String from, String to) {

        if (from == null || to == null) {
            return;
        }

        if (!allowed(from, to)) {
            return;
        }

        // 执行计数逻辑
        Counter.builder(METER_ID_NAME)
                .tag("from", from)
                .tag("to", to)
                .register(registry)
                .increment();
    }

    /**
     * 判断给定上下游URI是否允许计数
     *
     * @param from 上游URI，非空
     * @param to   下游URI，非空
     * @return
     */
    private boolean allowed(String from, String to) {

        // 读取配置文件中关于允许计数 Path 配置项，示例：$path1, $path2
        final String paths = environment.getProperty(ALLOW_COUNT_PATH_KEY);
        if (StringUtils.isBlank(paths)) {
            return false;
        }

        for (String path : parse(paths)) {
            if (from.equals(path) || to.equals(path)) {
                return true;
            }

            // 对下游接口做通配支持（上游接口前缀过于统一，会导致监控指标过多，内存溢出），下游接口至少应到接口名层级
            // 如 /com.fulu.game.cp.es.CpUserSearchComponentService/ 必须带 / 原因是防止使用类似 /com.fulu 之类的前缀，导致指标过多
            if (to.startsWith(path) && path.endsWith("/")) {
                return true;
            }
        }

        return false;
    }

    private static final char SEPARATOR = ',';

    private Set<String> parse(String s) {
        final Set<String> paths = new HashSet<>();
        for (String part : StringUtils.split(s, SEPARATOR)) {
            if (StringUtils.isNotBlank(part)) {
                paths.add(part.trim());
            }
        }
        return paths;
    }

}
