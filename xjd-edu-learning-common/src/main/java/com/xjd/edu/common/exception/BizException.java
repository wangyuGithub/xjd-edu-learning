package com.xjd.edu.common.exception;

import com.xjd.edu.common.error.CommonError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizException extends RuntimeException {

    protected Integer code;
    protected String message;

    public BizException(String message) {
        this.message = message;
    }

    public BizException(CommonError error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

}
