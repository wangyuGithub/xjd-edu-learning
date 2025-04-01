package com.xjd.edu.filter;

import com.xjd.edu.config.AnonymousConfig;
import com.xjd.edu.enums.HostTypeEnum;
import com.xjd.edu.model.GamePrincipal;
import com.xjd.edu.model.HostConfig;
import com.xjd.edu.service.AuthenticationService;
import com.xjd.edu.service.TokenService;
import com.xjd.edu.utils.EncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.xjd.edu.config.AppConfig.*;
import static com.xjd.edu.utils.WebHelper.getLoginToken;


@Slf4j
@Component
public class GameAuthenticationFilter implements GlobalFilter, Ordered {

    @Autowired
    private AntPathMatcher matcher;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AnonymousConfig anonymousConfig;
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private HostConfig config;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        final ServerHttpRequest request = exchange.getRequest();
        final String path = request.getPath().value();

        // 前一个过滤器有设置，所以这里一定取得到
        final String requestId = exchange.getAttribute(X_REQUEST_ID);
        final String token = getLoginToken(request);

        // 匿名请求（免登录）
        if (checkAnonymousRequest(path)) {
            return chain.filter(mutateServerWebExchange(exchange, null, requestId));
        }

        // 执行认证，返回 principal 信息
        return authenticationService.auth(exchange, token)
                .map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                // 记录错误
                .doOnError(e -> log.error("认证出错 token: {}", token, e))
                // 续租 + 路由 | 未登录
                .flatMap(opt -> opt.map(routeWithRenew(exchange, chain, token, requestId)).orElseGet(this.noLogin(exchange)));
    }

    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 续租 + 路由
     *
     * @param exchange
     * @param chain
     * @param token
     * @param requestId
     * @return
     */
    private Function<GamePrincipal, Mono<Void>> routeWithRenew(ServerWebExchange exchange, GatewayFilterChain chain, String token, String requestId) {
        return principal -> tokenService.renew(token, principal).then(chain.filter(this.mutateServerWebExchange(exchange, principal, requestId)));
    }

    /**
     * 封装返回值
     *
     * @param exchange
     * @return
     */
    private Supplier<Mono<Void>> noLogin(ServerWebExchange exchange) {

        final MDC.MDCCloseable closeable = MDC.putCloseable(X_REQUEST_ID, exchange.getAttribute(X_REQUEST_ID));
        log.info("未认证请求 uri: {}, token: {}", exchange.getRequest().getURI().getPath(), getLoginToken(exchange.getRequest()));
        closeable.close();

        final ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.setStatusCode(HttpStatus.OK);
        final String body = EncryptUtils.needEncrypt(exchange) ? NO_LOGIN_BODY_ENCODE : NO_LOGIN_BODY;
        return () -> response.writeWith(Mono.just(response.bufferFactory().wrap(body.getBytes())));
    }

    /**
     * 检查匿名请求
     *
     * @param action
     * @return
     */
    private boolean checkAnonymousRequest(String action) {
        return anonymousConfig.getAnonUrl().stream().anyMatch(e -> matcher.match(e, action));
    }

    /**
     * 改变 ServerWebExchange 对象
     *
     * @param exchange
     * @param principal
     * @param requestId
     */
    private ServerWebExchange mutateServerWebExchange(ServerWebExchange exchange, GamePrincipal principal, String requestId) {
        return exchange.mutate()
                .principal(Mono.justOrEmpty(principal))
                .request(exchange.getRequest()
                        .mutate()
                        .headers(headers -> {
                            headers.set(X_REQUEST_HOST, exchange.getRequest().getURI().getHost());
                            headers.set(X_REQUEST_ID, requestId);
                            if (principal != null) {
                                headers.set(X_AUTH_ID, principal.getName());
                            } else {
                                headers.set(X_AUTH_ID, "");     // 防止伪造
                            }
                            getAppType(exchange).map(Object::toString).ifPresent(appType -> headers.set(X_APP_TYPE, appType));
                        }).build()
                ).build();
    }

    /**
     * 获取AppType，新增App时需要调整该逻辑
     *
     * @param exchange
     * @return
     */
    private Optional<Integer> getAppType(ServerWebExchange exchange) {
        final HostTypeEnum type = config.getType(exchange.getRequest().getURI().getHost());
        if (type == null) {
            return Optional.empty();
        }
        switch (type) {
            case APP:
            case APP_V2:
            case H5:
            case GUILD:
                return Optional.of(1);
            case H5_PLAYMATE:
            case APP_PLAYMATE:
                return Optional.of(2);
            default:
                return Optional.empty();
        }

    }


}
