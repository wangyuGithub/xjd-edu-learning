package com.xjd.edu.user.controller.login.service.impl;

import com.xjd.edu.common.enums.HostTypeEnum;
import com.xjd.edu.common.model.login.LoginModel;
import com.xjd.edu.common.model.login.LoginResult;
import com.xjd.edu.user.controller.login.auth.AuthenticationFactory;
import com.xjd.edu.user.controller.login.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zsw
 * @description:
 * @date 2021-01-14 17:52:27
 */
@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationFactory authenticationFactory;

    @Override
    public LoginResult login(LoginModel loginModel, HostTypeEnum typeEnum) {
        return authenticationFactory
                .getInstance(typeEnum)
                .login(loginModel,typeEnum);
    }

    @Override
    public void sendCode(String mobile) {
        /*ApiResult<String> result;
        try {
            result = SMSCodeUtil.sendVerificationCode(mobile);
        } catch (Exception e) {
            log.info("发送短信出现异常：{}", mobile, e);
            throw new BizException("发送短信失败");
        }
        if (!result.isSuccessful()) {
            throw new BizException(result.getCode(), result.getMessage());
        }*/
    }
}
