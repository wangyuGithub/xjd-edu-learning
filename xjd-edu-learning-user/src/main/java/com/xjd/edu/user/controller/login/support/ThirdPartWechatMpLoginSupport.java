package com.xjd.edu.user.controller.login.support;

import com.google.common.collect.Lists;
import com.xjd.edu.common.entity.User;
import com.xjd.edu.common.enums.LoginTypeEnum;
import com.xjd.edu.common.model.login.LoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 微信H5登录
 *
 * @author zsw
 * @description:
 * @date 2021-01-22 14:51:57
 */
@Slf4j
@Component
public class ThirdPartWechatMpLoginSupport extends AbsLoginSupport {

    /*@Autowired
    private AppUserDeviceService appUserDeviceService;
    @Autowired
    private DictService dictService;*/

    @Override
    public List<LoginTypeEnum> type() {
        return Lists.newArrayList(LoginTypeEnum.THIRD_PART_WECHAT_MP);
    }

    @Override
    public User doLogin(LoginModel loginModel) {
       /* String mobile = loginModel.getMobile();
        String code = loginModel.getCode();
        String verifyCode = loginModel.getVerifyCode();

        Map<String,Map<String,String>> configMap = dictService.findObjectValue(Constant.APP_USER_CONFIG, Constant.IOS_AUDIT_ACCOUNT, Map.class).orElse(Maps.newHashMap());
        Integer appType = AppType.of(loginModel.getClientInfo()).map(AppType::getValue).orElse(AppType.PI_PI.getValue());
        Map<String, String> accountConfig = configMap.get(appType.toString());
        String iosAuditMobile = accountConfig.get("mobile");
        String iosAuditCode = accountConfig.get("code");

//        if (!DEFAULT_MOBILE.equals(mobile) || !DEFAULT_CODE.equals(verifyCode)) {
        if (ObjectUtil.notEqual(iosAuditMobile,mobile) || ObjectUtil.notEqual(iosAuditCode,verifyCode)) {
            String redisVerifyCode = SMSCodeUtil.getVerificationCode(mobile);
            if (!Objects.equals(redisVerifyCode, verifyCode)) {
                throw new LoginException(LoginException.ExceptionCode.VERIFY_CODE_ERROR);
            }
        }
        User userCheck = userService.findByMobile(mobile);
        if (userCheck == null) {
            throw new LoginException(LoginException.ExceptionCode.MOBILE_NOT_EXITS);
        }
        WxMpUser wxMpUser = appUserDeviceService.getWxMaServiceSupply(code, loginModel);
        if (wxMpUser == null) {
            throw new LoginException(LoginException.ExceptionCode.WX_AUTH_ERROR);
        }
        ThirdPartyLogin thirdPartyLoginModel = new ThirdPartyLogin();
        thirdPartyLoginModel.setOpenId(wxMpUser.getOpenId());
        thirdPartyLoginModel.setUnionId(wxMpUser.getUnionId());

        //皮皮
        if (LoginTypeEnum.THIRD_PART_WECHAT_MP.getKey().equals(loginModel.getLoginType())) {
            thirdPartyLoginModel.setLoginType(UserAccountTypeEnum.LCHEN_MP_WECHAT.getType());
        } else {
            //理想玩伴
            thirdPartyLoginModel.setLoginType(UserAccountTypeEnum.PLAYMATE_MP_WECHAT.getType());
        }

        loginModel.setThirdPartyLogin(thirdPartyLoginModel);
        updateUserPublicOpenId(userCheck.getId(), wxMpUser.getOpenId(), thirdPartyLoginModel.getLoginType(), wxMpUser.getUnionId());
        return userCheck;*/
        log.info("ThirdPartAppleLoginSupport");
        return null;
    }

    public void updateUserPublicOpenId(Integer userId, String publicOpenId, Integer type, String unionId) {
        /*User user = userService.findById(userId);
        if (StringUtils.isBlank(publicOpenId) || user == null) {
            return;
        }

        UserBO param = new UserBO();
        param.setPublicOpenId(publicOpenId);
        List<User> users = userService.findByParameterBO(param);
        User publicUser = CollectionUtils.isEmpty(users) ? null : users.get(Constant.CONSTANT_ZERO);
        if (publicUser != null && !userId.equals(publicUser.getId())) {
            User userUpdate = new User();
            userUpdate.setId(publicUser.getId());
            userUpdate.setPublicOpenId(userId + "-" + publicOpenId + "-" + System.currentTimeMillis());
            userService.update(userUpdate);
        }
        if (!Objects.equals(user.getPublicOpenId(), publicOpenId)) {
            User updateUser = new User();
            updateUser.setId(userId);
            updateUser.setPublicOpenId(publicOpenId);
            userService.update(updateUser);
        }

        //处理部分用户user表public_open_Id存在，account表数据不存在
        UserAccount userAccount = userAccountService.findByOpenIdAndType(publicOpenId, type);
        if (userAccount != null) {
            return;
        }
        userAccount = userAccountService.findByUserIdAndType(userId, type);
        if (userAccount == null) {
            //新建新的用户account
            UserAccount newUserAccount = new UserAccount(userId, publicOpenId, unionId, type);
            newUserAccount.setCreateTime(new Date());
            newUserAccount.setUpdateTime(new Date());
            log.info("新添加 userAccount {}", newUserAccount);
            userAccountService.create(newUserAccount);
            return;
        }
        if (Objects.equals(userAccount.getOpenId(), publicOpenId)) {
            return;
        }
        userAccount.setUpdateTime(new Date());
        userAccount.setOpenId(publicOpenId);
        userAccount.setUnionId(unionId);
        userAccountService.update(userAccount);*/
    }

}
