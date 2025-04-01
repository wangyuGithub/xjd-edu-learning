package com.xjd.edu.user.controller.login.support;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.xjd.edu.common.dict.DictService;
import com.xjd.edu.common.entity.User;
import com.xjd.edu.common.enums.LoginTypeEnum;
import com.xjd.edu.common.exception.LoginException;
import com.xjd.edu.common.model.login.LoginModel;
import com.xjd.edu.common.utils.SMSCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author zsw
 * @description:
 * @date 2021-01-22 13:47:37
 */
@Slf4j
@Component
public class MobileVerifyLoginSupport extends AbsLoginSupport {

    //@Autowired
    //private DictService dictService;

    @Override
    public List<LoginTypeEnum> type() {
        return Lists.newArrayList(LoginTypeEnum.MOBILE_VERIFY);
    }

    @Override
    public User doLogin(LoginModel loginModel) {
        if (StringUtils.isEmpty(loginModel.getMobile())) {
            throw new LoginException(LoginException.ExceptionCode.MOBILE_NULL);
        }
        if (StringUtils.isBlank(loginModel.getCode())) {
            throw new LoginException(LoginException.ExceptionCode.VERIFY_CODE_NULL);
        }

//        Map<String, Map<String,String>> configMap = dictService.findObjectValue(Constant.APP_USER_CONFIG, Constant.IOS_AUDIT_ACCOUNT, Map.class).orElse(Maps.newHashMap());
//        Integer appType = AppType.of(loginModel.getClientInfo()).map(AppType::getValue).orElse(AppType.PI_PI.getValue());
//        Map<String, String> accountConfig = configMap.get(appType.toString());
//        String iosAuditMobile = accountConfig.get("mobile");


//        if (Objects.equal(loginModel.getMobile(), iosAuditMobile)) {
//            return mobileLogin(loginModel);
//        }
        /*if (!SMSCodeUtil.validateMobilePattern(loginModel.getMobile())) {
            log.warn("手机号不合法 mobile: {}", loginModel.getMobile());
            throw new LoginException(LoginException.ExceptionCode.MOBILE_ILLEGAL);
        }
        String redisVerifyCode = SMSCodeUtil.getVerificationCode(loginModel.getMobile());
        log.info("mobile: {}, code: {}, Redis code: {}", loginModel.getMobile(), loginModel.getCode(), redisVerifyCode);
        if (!Objects.equal(loginModel.getCode(), redisVerifyCode)) {
            throw new LoginException(LoginException.ExceptionCode.VERIFY_CODE_ERROR);
        }*/
        return mobileLogin(loginModel);
    }

}
