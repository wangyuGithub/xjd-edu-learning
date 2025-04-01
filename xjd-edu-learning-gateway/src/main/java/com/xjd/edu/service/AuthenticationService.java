package com.xjd.edu.service;

import com.xjd.edu.enums.HostTypeEnum;
import com.xjd.edu.model.GamePrincipal;
import com.xjd.edu.model.HostConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zlikun
 * @date 2022/2/15 18:59
 */
@Slf4j
@Service
public class AuthenticationService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private HostConfig config;

    @Value("${config.evn.prefix}")
    private String prefix;

    /**
     * 认证逻辑
     *
     * @param exchange
     * @param token
     * @return
     */
    public Mono<GamePrincipal> auth(ServerWebExchange exchange, String token) {
        if (token == null) {
            return Mono.empty();
        }

        switch (this.type(exchange)) {
            case PIPI_ADMIN:
                return tokenService.getAdmin(token);
            case APP:
            case APP_V2:
            case H5:
            case GUILD:
            case APP_PLAYMATE:
            default:
                return tokenService.get(token);
        }

    }

    /**
     * 获取 HOST 类型
     *
     * @param exchange
     * @return
     */
    private HostTypeEnum type(ServerWebExchange exchange) {
        final HostTypeEnum type = config.getType(exchange.getRequest().getURI().getHost());
        return type != null ? type : HostTypeEnum.APP;
    }

}
