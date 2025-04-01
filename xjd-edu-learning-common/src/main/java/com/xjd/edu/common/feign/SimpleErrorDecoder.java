package com.xjd.edu.common.feign;

import com.xjd.edu.common.exception.BizException;
import com.xjd.edu.toolkit.exception.BlockingException;
import feign.Feign;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * OpenFeign 错误解码器，用于统一包装异常响应
 *
 * @author zlikun
 * @date 2021/06/24 16:49
 */
@Slf4j
@Component
@ConditionalOnClass(Feign.class)
public class SimpleErrorDecoder extends ErrorDecoder.Default {

    @Autowired
    private StandardEnvironment environment;

    @Override
    public Exception decode(String methodKey, Response response) {

        // 限流响应状态码
        if (response != null && response.status() == HttpStatus.TOO_MANY_REQUESTS.value()) {
            return new BlockingException();
        }

        final Exception ex = super.decode(methodKey, response);

        // 如果是 RetryableException 则返回继续重试
        if (ex instanceof RetryableException) {
            return ex;
        }

        log.error("请求API[{}]出错", methodKey, ex);

        final BizException biz = new BizException(ex);
        biz.setCode(response.status());
        biz.setMessage("内部API请求失败");
        return biz;
    }

}
