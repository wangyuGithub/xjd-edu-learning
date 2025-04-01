package com.xjd.edu.user.controller.login.service;


import com.xjd.edu.common.enums.HostTypeEnum;
import com.xjd.edu.common.model.login.LoginModel;
import com.xjd.edu.common.model.login.LoginResult;

/**
 * @author zsw
 * @description:
 * @date 2021-01-14 17:50:42
 */
public interface AuthenticationService {

    /**
     * 登录
     *
     * @param loginModel
     * @param typeEnum
     */
    LoginResult login(LoginModel loginModel, HostTypeEnum typeEnum);

    /**
     * 发送验证码
     *
     * @param mobile
     */
    void sendCode(String mobile);


}
