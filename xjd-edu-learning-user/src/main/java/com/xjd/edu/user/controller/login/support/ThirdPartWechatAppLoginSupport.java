package com.xjd.edu.user.controller.login.support;

import com.google.common.collect.Lists;
import com.xjd.edu.common.entity.User;
import com.xjd.edu.common.enums.LoginTypeEnum;
import com.xjd.edu.common.model.login.LoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zsw
 * @description:
 * @date 2021-01-22 14:51:57
 */
@Slf4j
@Component
public class ThirdPartWechatAppLoginSupport extends AbsLoginSupport {
    @Override
    public List<LoginTypeEnum> type() {
        return Lists.newArrayList(LoginTypeEnum.THIRD_PART_WECHAT_APP);
    }

    @Override
    public User doLogin(LoginModel loginModel) {
        /*ThirdPartyLogin thirdPartyLogin = loginModel.getThirdPartyLogin();
        // 校验sign
        String sign = thirdPartyLogin.getAccessToken() + thirdPartyLogin.getLoginType()
                + thirdPartyLogin.getOpenId() + thirdPartyLogin.getTimestamp();
        if (!thirdPartyLogin.getSign().equalsIgnoreCase(SecureUtil.md5(sign))) {
            throw new LoginException(LoginException.ExceptionCode.VERIFY_FAIL);
        }
        return thirdPartLogin(loginModel);*/
        log.info("ThirdPartAppleLoginSupport");
        return null;
    }
}
