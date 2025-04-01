package com.xjd.edu.config;

import java.time.Duration;

/**
 * @author zlikun
 * @date 2022/2/15 18:56
 */
public class AppConfig {

    /**
     * 请求消息头：请求Id
     */
    public static final String X_REQUEST_ID = "X-Request-Id";
    /**
     * 请求消息头：请求Host
     */
    public static final String X_REQUEST_HOST = "requestHost";
    /**
     * 请求消息头：请求Token
     */
    public static final String X_LOGIN_TOKEN = "token";
    /**
     * 请求消息头：认证Id
     */
    public static final String X_AUTH_ID = "X-Auth-Id";
    /**
     * 请求消息头：AppType
     */
    public static final String X_APP_TYPE = "X-App-Type";
    /**
     * 未登录响应明文
     */
    public static final String NO_LOGIN_BODY = "{\"msg\":\"登录状态已失效,请重新登录!\",\"status\":501}";
    /**
     * 未登录响应编码 (BASE64)
     */
    public static final String NO_LOGIN_BODY_ENCODE = "eyJtc2ciOiLnmbvlvZXnirbmgIHlt7LlpLHmlYgs6K+36YeN5paw55m75b2VISIsInN0YXR1cyI6NTAxfQ==";
    /**
     * 系统错误响应明文
     */
    public static final String INTERNAL_ERROR_BODY = "{\"msg\":\"操作失败\",\"status\":500}";
    /**
     * 系统错误响应编码(BASE64)
     */
    public static final String INTERNAL_ERROR_BODY_ENCODE = "eyJtc2ciOiLmk43kvZzlpLHotKUiLCJzdGF0dXMiOjUwMH0=";
    /**
     * 续租间隔毫秒数：1天
     */
    public static final long RENEW_INTERVAL_MS = 24 * 60 * 60 * 1000;
    /**
     * Token 过期时间：30天
     */
    public static final Duration TOKEN_DURATION = Duration.ofDays(30);
    /**
     * 认证用户标识名称（Redis）
     */
    public static final String PRINCIPAL_NAME_REDIS_FIELD = "id";
    /**
     * 续租时间戳字段名称（Redis）
     */
    public static final String RENEW_TIMESTAMP_REDIS_FIELD = "_renew_timestamp";
    /**
     * 认证用户标识名称（Redis）
     */
    public static final String STATUS_REDIS_FIELD = "status";
    /**
     * 禁用
     */
    public static final int DISABLE = 1;
    /**
     * 启用
     */
    public static final int ENABLE = 0;

/*    *//**
     * 调用键日志开关（用于实现日志抽样控制）
     *//*
    public static final String CHAIN_LOGGING_ALLOW_KEY = "_chain_logging_allow";*/

}
