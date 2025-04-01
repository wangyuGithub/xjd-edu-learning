package com.xjd.edu.user.controller.login.auth;

import com.google.common.collect.Lists;
import com.xjd.edu.common.enums.HostTypeEnum;
import com.xjd.edu.common.enums.LoginTypeEnum;
import com.xjd.edu.common.model.login.LoginModel;
import com.xjd.edu.common.model.login.LoginResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zsw
 * @description:
 * @date 2021-01-14 18:03:09
 */
@Slf4j
@Component
public class H5Authentication extends AbsAuthentication {

    @Override
    public List<HostTypeEnum> type() {
        return Lists.newArrayList(HostTypeEnum.H5);
    }

    @Override
    public LoginResult login(LoginModel loginModel, HostTypeEnum hostTypeEnum) {
        log.info("H5 Authentication loginModel: {}", loginModel);
        return loginFactory.getInstance(LoginTypeEnum.getByKey(loginModel.getLoginType())).login(loginModel, hostTypeEnum);
    }
}
