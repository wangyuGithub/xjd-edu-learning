package com.xjd.edu.utils;

import cn.hutool.core.codec.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * WebFlux 不支持 servlet，所以这里定制该工具类
 *
 * @author zlikun
 * @date 2021/08/31 14:06
 * @see com.fulu.common.utils.encrypt.EncryptUtils
 */
@Slf4j
@Component
public class EncryptUtils {

    private static final String CHECK_HEADER = "User-Check";
    private static final String VERSION = "1.0";
    private static final String VERSION_V2 = "2.0";

    public static boolean needEncrypt(ServerWebExchange exchange) {
        final String bes = exchange.getRequest().getHeaders().getFirst(CHECK_HEADER);
        return VERSION.equals(bes) || VERSION_V2.equals(bes);
    }

    public static String encode(String source) {
        return Base64.encode(source);
    }

}