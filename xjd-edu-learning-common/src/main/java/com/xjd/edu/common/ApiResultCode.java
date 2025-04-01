package com.xjd.edu.common;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;

/**
 * 预设响应码
 */
@Getter
public enum ApiResultCode {

    OK(0, "成功"),
    INTERNAL_ERROR(-1, "系统错误"),
    ILLEGAL_ARGUMENT_ERROR(-2, "参数错误"),
    PAGE_ERROR(-3, "分页错误"),

    ;
    private int code;
    private String message;

    ApiResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public boolean isPresent(int code) {
        return ObjectUtil.equal(this.getCode(),code);
    }

    public boolean isNotPresent(int code) {
        return !isPresent(code);
    }


}
