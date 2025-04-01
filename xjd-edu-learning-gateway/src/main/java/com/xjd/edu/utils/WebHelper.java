package com.xjd.edu.utils;

import cn.hutool.core.util.IdUtil;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;

import java.util.Optional;

import static com.xjd.edu.config.AppConfig.X_LOGIN_TOKEN;
import static com.xjd.edu.config.AppConfig.X_REQUEST_ID;


/**
 * @author zlikun
 * @since 2023/1/13
 */
public class WebHelper {

    public static String getRequestId(ServerHttpRequest request) {
        return Optional.ofNullable(request.getHeaders().getFirst(X_REQUEST_ID))
                .filter(StringUtils::hasText)
                .orElse(String.format("route_%s", IdUtil.fastSimpleUUID()));
    }

    public static String getLoginToken(ServerHttpRequest request) {
        return Optional.ofNullable(request.getHeaders().getFirst(X_LOGIN_TOKEN))
                .filter(StringUtils::hasText)
                .orElse(request.getQueryParams().getFirst(X_LOGIN_TOKEN));
    }

}
