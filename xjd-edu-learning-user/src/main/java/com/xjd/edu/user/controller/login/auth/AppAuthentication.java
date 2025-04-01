package com.xjd.edu.user.controller.login.auth;

import com.google.common.collect.Lists;
import com.xjd.edu.common.enums.HostTypeEnum;
import com.xjd.edu.common.enums.LoginTypeEnum;
import com.xjd.edu.common.exception.LoginException;
import com.xjd.edu.common.model.login.LoginModel;
import com.xjd.edu.common.model.login.LoginResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zsw
 * @description:
 * @date 2021-01-14 18:03:09
 */
@Slf4j
@Component
public class AppAuthentication extends AbsAuthentication {

    @Override
    public List<HostTypeEnum> type() {
        return Lists.newArrayList(HostTypeEnum.APP);
    }

    @Override
    public LoginResult login(LoginModel loginModel, HostTypeEnum hostTypeEnum) {
        return loginFactory.getInstance(getLoginTypeByModel(loginModel)).login(loginModel, hostTypeEnum);
    }


    /**
     * @param loginModel
     * @return
     */
    private LoginTypeEnum getLoginTypeByModel(LoginModel loginModel) {
        log.info("App Authentication loginModel: {}", loginModel);
        LoginTypeEnum result = null;
        String mobile = loginModel.getMobile();
        if (StringUtils.hasText(mobile) && StringUtils.hasText(loginModel.getCode())) {
            result = LoginTypeEnum.MOBILE_VERIFY;
        }

        if (!StringUtils.hasText(loginModel.getCode()) && StringUtils.hasText(loginModel.getAccessToken())) {
            result = LoginTypeEnum.MOBILE_ONE_CLICK;
        }
        if (result == null) {
            result = LoginTypeEnum.getByKey(loginModel.getLoginType());
        }
        log.info("current login type is:{}", result);
        if (result == null) {
            throw new LoginException(LoginException.ExceptionCode.LOGIN_TYPE_NULL);
        }
        return result;
    }

}
