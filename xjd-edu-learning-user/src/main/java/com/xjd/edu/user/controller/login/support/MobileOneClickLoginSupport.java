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
 * @date 2021-01-22 14:30:18
 */
@Slf4j
@Component
public class MobileOneClickLoginSupport extends AbsLoginSupport {

    //@Value("${config.aliMobileVerification.accessKeyId}")
    //private String accessKeyId;
    //@Value("${config.aliMobileVerification.secretx}")
    //private String secretx;

    //@Autowired
    //private AppUserDeviceService appUserDeviceService;

    @Override
    public List<LoginTypeEnum> type() {
        return Lists.newArrayList(LoginTypeEnum.MOBILE_ONE_CLICK);
    }

    @Override
    public User doLogin(LoginModel loginModel) {
        return null;
        /*if (StringUtils.isEmpty(loginModel.getAccessToken())) {
            throw new LoginException(LoginException.ExceptionCode.MOBILE_ACCESS_TOKEN_NULL);
        }
        String mobile = appUserDeviceService.getMobile(loginModel.getAccessToken());
        if (StringUtils.isEmpty(mobile)) {
            throw new LoginException(LoginException.ExceptionCode.GET_MOBILE_FAIL);
        }
        if (!SMSCodeUtil.validateMobilePattern(mobile)) {
            log.warn("手机号不合法 mobile: {}", mobile);
            throw new LoginException(LoginException.ExceptionCode.MOBILE_ILLEGAL);
        }
        loginModel.setMobile(mobile);

        return mobileLogin(loginModel);*/
    }

    /**
     * 阿里号码认证
     * 参考文档：https://help.aliyun.com/document_detail/115500.html?spm=a2c4g.11186623.6.568.3fc243447UZ9k6
     *
     * @return
     */
    public String getMobile(String accessToken, String errorMsg) {
        /*DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, secretx);
        IAcsClient client = new DefaultAcsClient(profile);
        GetMobileRequest request = new GetMobileRequest();
        request.setAccessToken(accessToken);
        String mobile = null;
        try {
            GetMobileResponse response = client.getAcsResponse(request);
            log.info("alibaba phone auth accessToken: {}, response: {}", accessToken, new Gson().toJson(response));
            mobile = response.getGetMobileResultDTO().getMobile();
            if (!StringUtils.equalsIgnoreCase("OK", response.getCode()) || StringUtils.isEmpty(mobile)) {
                throw new UserException(UserException.ExceptionCode.AUTO_LOGIN_EXCEPTION, errorMsg);
            }
        } catch (ServerException e) {
            log.error("alibaba phone auth server error: {}", e.getErrMsg());
            throw new UserException(UserException.ExceptionCode.AUTO_LOGIN_EXCEPTION, errorMsg);//NOPMD
        } catch (ClientException e) {
            log.error("alibaba phone auth client error: {}", e.getErrMsg());
            throw new UserException(UserException.ExceptionCode.AUTO_LOGIN_EXCEPTION, errorMsg);//NOPMD
        }
        return mobile;*/
        log.info("MobileOneClickLoginSupport");
        return null;
    }
}
