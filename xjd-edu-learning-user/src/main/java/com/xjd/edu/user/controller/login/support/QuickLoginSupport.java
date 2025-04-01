package com.xjd.edu.user.controller.login.support;

import com.google.common.collect.Lists;
import com.xjd.edu.common.entity.User;
import com.xjd.edu.common.enums.LoginTypeEnum;
import com.xjd.edu.common.exception.LoginException;
import com.xjd.edu.common.model.login.LoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class QuickLoginSupport extends AbsLoginSupport {

    @Override
    public List<LoginTypeEnum> type() {
        return Lists.newArrayList(LoginTypeEnum.SWITCH_ACCOUNT_QUICK_LOGIN);
    }

    @Override
    protected User doLogin(LoginModel loginModel) throws LoginException {
        return loginModel.getUser();
    }
}
