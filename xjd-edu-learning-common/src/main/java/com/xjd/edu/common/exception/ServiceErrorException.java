package com.xjd.edu.common.exception;

import lombok.Getter;

@Getter
public class ServiceErrorException extends BizException {


    public ServiceErrorException(String msg) {
        super();
        this.code = 9999;
        this.message = msg;
    }

}
