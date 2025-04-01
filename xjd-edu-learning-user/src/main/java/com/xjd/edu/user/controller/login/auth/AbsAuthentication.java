package com.xjd.edu.user.controller.login.auth;

import com.xjd.edu.common.enums.HostTypeEnum;
import com.xjd.edu.common.model.login.LoginModel;
import com.xjd.edu.common.model.login.LoginResult;
import com.xjd.edu.common.service.TokenService;
import com.xjd.edu.user.controller.login.support.LoginFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zsw
 * @description:
 * @date 2021-01-14 17:54:00
 */
@Slf4j
@Component
public abstract class AbsAuthentication {

    @Autowired
    protected TokenService tokenService;

    @Autowired
    protected LoginFactory loginFactory;

    public abstract List<HostTypeEnum> type();

    /**
     * 登录
     *
     * @param loginModel
     * @return
     */
    public abstract LoginResult login(LoginModel loginModel, HostTypeEnum hostTypeEnum);

}
