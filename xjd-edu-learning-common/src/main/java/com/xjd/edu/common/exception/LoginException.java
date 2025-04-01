package com.xjd.edu.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class LoginException extends RuntimeException {

    private ExceptionCode exceptionCode;

    private Integer code;
    private String message;

    @AllArgsConstructor
    @Getter
    public enum ExceptionCode {
        LOGIN_TYPE_NULL(3000, "登录类型不能为空"),
        VERIFY_CODE_ERROR(3001, "验证码错误，请重新输入"),
        WX_AUTH_ERROR(3002, "微信授权失效!"),
        FENQILE_AUTH_ERROR(3003, "分期乐授权失效!"),
        MOBILE_NULL(3004, "手机号为空"),
        MOBILE_ACCESS_TOKEN_NULL(3005, "一键登录access_token为空"),
        GET_MOBILE_FAIL(3006, "一键登录获取手机号失败"),
        VERIFY_FAIL(3007, "校验失败"),
        APPLE_LOGIN_CODE_NULL(3008, "苹果登录code不能为空"),
        VERIFY_CODE_NULL(3009, "苹果登录code不能为空"),
        FORBID(3010, "你的行为违反平台政策，暂时无法使用"),
        ADMIN_LOGIN_LIMIT(3011, "半个小时之内不能再登录"),
        ADMIN_NOT_EXITS(3012, "admin用户不存在"),
        ADMIN_FORBID(3013, "admin用户已被禁用"),
        ADMIN_PASSWORD_NOT_MATCH(3014, "密码不正确"),
        MOBILE_NOT_EXITS(3015, "手机号不存在"),
        MOBILE_ILLEGAL(3016, "你的手机号存在风险，已被禁止使用"),
        IP_FORBID(3017, "该IP地址已被禁止登录"),
        DEVICE_FORBID(3018, "该设备已被禁止登录"),
        AREA_REGISTER_FORBID(3019, "当前国家/地区暂不支持注册"),
        AREA_LOGIN_FORBID(3020, "当前国家/地区暂不支持登录"),
        REAL_NAME_AUTH_BLACK_LIST_FORBID(3021, "你因违反平台规则，已被禁止使用"),

        ;
        private int code;
        private String msg;
    }

    public LoginException(ExceptionCode exceptionCode) {
        super();
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMsg();
        this.exceptionCode = exceptionCode;
    }
}
