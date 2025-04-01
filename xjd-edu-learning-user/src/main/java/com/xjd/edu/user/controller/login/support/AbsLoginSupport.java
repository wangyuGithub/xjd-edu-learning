package com.xjd.edu.user.controller.login.support;

import cn.hutool.core.collection.CollUtil;
import com.xjd.edu.common.entity.User;
import com.xjd.edu.common.enums.HostTypeEnum;
import com.xjd.edu.common.enums.LoginTypeEnum;
import com.xjd.edu.common.enums.OsEnum;
import com.xjd.edu.common.exception.BizException;
import com.xjd.edu.common.exception.LoginException;
import com.xjd.edu.common.model.login.LoginModel;
import com.xjd.edu.common.model.login.LoginResult;
import com.xjd.edu.common.service.TokenService;
import com.xjd.edu.common.utils.DesensitizedUtil;
import com.xjd.edu.common.utils.UuidUtil;
import com.xjd.edu.user.service.UserService;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author zsw
 * @description:
 * @date 2021-01-22 13:46:58
 */
@Slf4j
@Component
public abstract class AbsLoginSupport {

    //@Autowired
    //private AppUserDeviceService appUserDeviceService;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private MeterRegistry registry;


    public abstract List<LoginTypeEnum> type();


    //@Autowired
    //private LogoutManager logoutManager;

    //@Autowired
    //private LocalDictService localDictService;

    /**
     * 监控各端登录频次（存在多个时只记录一个）
     *
     * @param types
     */
    protected void count(List<LoginTypeEnum> types) {
        // 容错处置
        final LoginTypeEnum type = CollUtil.getFirst(types);
        if (type == null) {
            return;
        }
        registry.counter("biz.login.requests", "type", type.name()).increment();
    }

    protected abstract User doLogin(LoginModel loginModel) throws LoginException;

    public LoginResult login(LoginModel loginModel, HostTypeEnum typeEnum) throws LoginException {
        // 监控统计
        count(this.type());
        // 登录逻辑
        User user = this.doLogin(loginModel);
        // 创建登录 Token
        final String token = tokenService.create(userService.findById(user.getId()), typeEnum);

        // 将用户存储到 Redis
        final LoginResult result = new LoginResult();
        BeanUtils.copyProperties(user, result);
        result.setMobile(DesensitizedUtil.mobilePhone(result.getMobile()));
        result.setToken(token);
        if (StringUtils.isEmpty(loginModel.getDeviceCert())) {
            result.setDeviceCert(UuidUtil.uuid());
        } else {
            result.setDeviceCert(loginModel.getDeviceCert());
        }
        // 旧账号退出登录
        try {
            //logoutManager.logout(originToken);
        } catch (Exception e) {
            log.error("旧账号退出登录失败", e);
        }

        return result;
    }

    /*public boolean isNewUser(User user) {
        if (user == null) {
            return false;
        }
        if (BooleanUtils.isTrue(user.isNewUser())) {
            return true;
        }
        if (user.getCreateTime() == null) {
            return false;
        }
        ExtensionNewUserConfig extensionNewUserConfig = localDictService.findObjectValue(DictConstant.EXTENSION_CONFIG, DictConstant.NEW_USER_CONFIG, ExtensionNewUserConfig.class).orElse(new ExtensionNewUserConfig());
        if (BooleanUtils.isFalse(extensionNewUserConfig.isEnable())) {
            return false;
        }
        Long newUserTime = Optional.ofNullable(extensionNewUserConfig.getNewUserTime()).orElse(600L);
        return DateUtil.between(user.getCreateTime(), DateUtil.date(), DateUnit.SECOND) < newUserTime;
    }*/

    /**
     * 手机号登录逻辑
     *
     * @param loginModel
     * @return
     */
    protected User mobileLogin(LoginModel loginModel) {
        String mobile = loginModel.getMobile();
        String ip = loginModel.getIp();
        String keyword = loginModel.getKeyword();
        Date searchTime = loginModel.getSearchTime();
        User user = userService.findByMobile(mobile);
        Integer uid = Optional.ofNullable(user).map(User::getId).orElse(null);
        if (user != null) {
            return user;
        }
        return user;
    }


    /**
     * 第三方登录逻辑
     *
     * @param loginModel
     * @return
     */
    /*protected User thirdPartLogin(LoginModel loginModel) {
        log.info("三方登录 loginModel: {}", loginModel);
        String keyword = loginModel.getKeyword();
        Date searchTime = loginModel.getSearchTime();
        ClientInfo clientInfo = loginModel.getClientInfo();
        ThirdPartyLogin thirdPartyLogin = loginModel.getThirdPartyLogin();

        if (thirdPartyLogin.getOpenId() == null) {
            return null;
        }
        UserAccount userAccount = userAccountService.findByOpenIdAndType(thirdPartyLogin.getOpenId(), thirdPartyLogin.getLoginType());
        log.info("根据openid和登录类型查询用户账户信息：{}", userAccount);

        //风控
        Integer uid = Optional.ofNullable(userAccount).map(UserAccount::getUserId).orElse(null);
        loginBefore.riskEventPloy(loginModel, uid, null, thirdPartyLogin.getOpenId(), type());
        if (userAccount == null && StringUtils.isNotBlank(thirdPartyLogin.getUnionId())) {

            UserAccountBO userAccountBO = new UserAccountBO();
            userAccountBO.setUnionId(thirdPartyLogin.getUnionId());
            List<UserAccount> accountList = Optional.ofNullable(userAccountService.findByParameter(userAccountBO)).orElse(new ArrayList<>());
            if (UserAccountTypeEnum.APP_QQ_LIST.contains(thirdPartyLogin.getLoginType())) {
                Integer type;
                type = UserAccountTypeEnum.LCHEN_APP_QQ.getType().equals(thirdPartyLogin.getLoginType()) ? UserAccountTypeEnum.PLAYMATE_APP_QQ.getType()
                        : UserAccountTypeEnum.LCHEN_APP_QQ.getType();
                userAccount = CollUtil.getFirst(accountList.stream().filter(it -> type.equals(it.getType()))
                        .collect(Collectors.toList()));
                if (userAccount == null) {
                    userAccount = CollUtil.getFirst(accountList);
                }
            } else if (UserAccountTypeEnum.APP_WECHAT_LIST.contains(thirdPartyLogin.getLoginType())) {
                Integer type;
                type = UserAccountTypeEnum.LCHEN_APP_WECHAT.getType().equals(thirdPartyLogin.getLoginType()) ? UserAccountTypeEnum.PLAYMATE_APP_WECHAT.getType()
                        : UserAccountTypeEnum.LCHEN_APP_WECHAT.getType();
                userAccount = CollUtil.getFirst(accountList.stream().filter(it -> type.equals(it.getType()))
                        .collect(Collectors.toList()));
                if (userAccount == null) {
                    userAccount = CollUtil.getFirst(accountList);
                }
            } else {
                userAccount = CollUtil.getFirst(accountList);
            }

            log.info("根据unionId查询用户账户信息：{}", userAccount);
            if (userAccount != null) {
                // 新建新的用户account
                UserAccount newUserAccount = new UserAccount(userAccount.getUserId(), thirdPartyLogin.getOpenId(), thirdPartyLogin.getUnionId(), thirdPartyLogin.getLoginType());
                newUserAccount.setCreateTime(new Date());
                newUserAccount.setUpdateTime(new Date());
                log.info("新添加 userAccount: {}", newUserAccount);
                try {
                    userAccountService.create(newUserAccount);
                } catch (Exception e) {
                    log.error("绑定三方信息失败：{}", e);
                }
            }
        }

        if (userAccount != null) {
            User user = userService.findById(userAccount.getUserId());
            log.info("根据用户Id查询用户信息：{}", user);
            // 写入用户unionid
            if (StringUtils.isNotBlank(thirdPartyLogin.getUnionId()) && StringUtils.isBlank(userAccount.getUnionId())) {
                userAccount.setUnionId(thirdPartyLogin.getUnionId());
                userAccountService.update(userAccount);
            }
            AccountBindDTO accountBindDTO = loginModel.getAccountBindDTO();
            if (accountBindDTO != null && accountBindDTO.getAccountType() != null
                    && UserAccountTypeEnum.MOBILE.getType().equals(accountBindDTO.getAccountType())) {
                thirdPartLoginBindMobile(accountBindDTO, user);
                userService.update(user);
            }
            return user;
        }

        User user = new User();
        // 第三方登录 不设置性别
        //user.setGender(thirdPartyLogin.getGender());
        user.setRegistIp(loginModel.getIp());

        // 第三方登录,也修改成使用游客昵称和默认头像
        user.setNickname(nickNameManager.getNickName());
        user.setSourceId(clientInfo.getPlatform());
        user.setRegistDeviceNo(clientInfo.get_imei());
        user.setRegisterType(OsEnum.parseByClientInfo(clientInfo));
        user.setAppType(AppType.of(clientInfo).map(AppType::getValue).orElse(AppType.PI_PI.getValue()));
        String cityName = EncryptUtil.getZhongwenURLDecoder(clientInfo.get_cityName());
        user.setCity(cityName);
        //绑定手机号
        AccountBindDTO accountBindDTO = loginModel.getAccountBindDTO();
        if (accountBindDTO != null && accountBindDTO.getAccountType() != null
                && UserAccountTypeEnum.MOBILE.getType().equals(accountBindDTO.getAccountType())) {
            thirdPartLoginBindMobile(accountBindDTO, user);
        }
        Integer userId = null;
        if (thirdPartyLogin.getType() != null) {
            log.info("新版本用户注册 user: {}", user);
            // 新版本
            userId = userService.createNewUser2(ParamTuples.of(user, clientInfo), keyword, searchTime);
            User currentUser = userService.findById(userId);
            userHistoryImgManager.save(userId, currentUser.getHeadPortraitsUrl(), null);
            user.setHeadPortraitsUrl(currentUser.getHeadPortraitsUrl());
        } else {
            // 老版本
            log.info("新版本用户注册 user: {}", user);
            userId = userService.createNewUser(ParamTuples.of(user, clientInfo), keyword, searchTime);
        }
        user.setId(userId);

        userAccount = new UserAccount(user.getId(), thirdPartyLogin.getOpenId(), thirdPartyLogin.getUnionId(), thirdPartyLogin.getLoginType());
        userAccount.setCreateTime(new Date());
        userAccount.setUpdateTime(new Date());
        registerWebRequestWatcher.request();
        log.info("注册用户 user: {}", user);
        userAccountService.create(userAccount);
        userService.addUserCode(user.getId());//设置用户code
        appUserDeviceService.saveDeviceInfo(user, clientInfo);
        user.setNewUser(true);

        return user;
    }*/

    /*private void thirdPartLoginBindMobile(AccountBindDTO accountBindDTO, User user) {
        // 绑定手机号
        log.info("第三方绑定手机号 accountBindDTO:{}", accountBindDTO);
        //存在accessToken就表明是本机号码一键绑定
        if (StringUtils.isNotEmpty(accountBindDTO.getPhoneAccessToken())) {
            accountBindDTO.setMobile(appUserDeviceService.getMobile(accountBindDTO.getPhoneAccessToken(), "一键绑定失败，请重试"));
        }
        if (StringUtils.isBlank(accountBindDTO.getMobile())) {
            throw new ParamsException(ParamsException.ExceptionCode.PARAM_NULL_EXCEPTION);
        }
        if (!SMSCodeUtil.validateMobilePattern(accountBindDTO.getMobile())) {
            log.warn("手机号不合法 mobile: {}", accountBindDTO.getMobile());
            throw new LoginException(LoginException.ExceptionCode.MOBILE_ILLEGAL);
        }
        User otherUser = userService.findByMobile(accountBindDTO.getMobile());
        log.info("user :{} ,otherUser:{}", user, otherUser);
        if (otherUser != null) {
            if (null != user.getId() && otherUser.getId().equals(user.getId())) {
                return;
            }
            throw new UserException(UserException.ExceptionCode.MOBILE_EXIST_CANNOT_UNBIND_EXCEPTION);
        }
        //非一键绑定需验证验证码
        if (StringUtils.isEmpty(accountBindDTO.getPhoneAccessToken())) {
            String redisVerifyCode = SMSCodeUtil.getVerificationCode(accountBindDTO.getMobile());
            log.info("手机号：{}，验证码：{}，redis验证码：{}", accountBindDTO.getMobile(), accountBindDTO.getVerifyCode(), redisVerifyCode);
            if (!Objects.equal(accountBindDTO.getVerifyCode(), redisVerifyCode)) {
                throw new ParamsException(ParamsException.ExceptionCode.VERIFY_CODE_ERROR_EXCEPTION);
            }
        }
        if (StringUtils.isNotBlank(user.getMobile())) {
            throw new UserException(UserException.ExceptionCode.USER_HAS_MOBILE_EXIST_CANNOT_BIND_EXCEPTION);
        }
        user.setMobile(accountBindDTO.getMobile());
        log.info("绑定手机号:user:{}", user);
    }*/

    /*private void checkUserAfter(User user, LoginModel loginModel) {
        try {
            if (StringUtils.isEmpty(user.getImId()) && null != user.getId()) {
                log.info("环信imId为空，用户ID {} 不为空，注册环信ID", user.getId());
                //注册im
                ImUser imUser = imUtil.userImReg(user);
                log.info("环信imUser：{}", imUser);
                if (null != imUser && imUser.isFlag()) {
                    User uptUser = new User();
                    uptUser.setId(user.getId());
                    uptUser.setImId(imUser.getUsername());
                    uptUser.setImPsw(imUser.getImPsw());
                    uptUser.setUpdateTime(new Date());
                    uptUser.setLoginIp(user.getRegistIp());
                    uptUser.setLoginTime(new Date());
                    //将修改更新到相关数据库中
                    userService.update(uptUser);

                    user.setImId(uptUser.getImId());
                    user.setImPsw(uptUser.getImPsw());
                    log.info("环信注册成功 imUser: {}", JSONObject.toJSON(imUser));
                    try {
                        Boolean isThirdPart = false;
                        if (!LoginTypeEnum.MOBILE_VERIFY.getKey().equals(loginModel.getLoginType())
                                && !LoginTypeEnum.MOBILE_ONE_CLICK.getKey().equals(loginModel.getLoginType())) {
                            isThirdPart = true;
                        }
                        user.setLoginTime(new Date());
                        user.setLoginIp(user.getRegistIp());
                        if (syncEs(user, isThirdPart)) {
                            log.info("同步用户到es成功 user: {}, isThirdPart: {}", user, isThirdPart);
                        } else {
                            log.error("同步用户到es失败 user: {}", user);
                        }
                    } catch (Exception e) {
                        log.error("同步用户到es失败 user: {}", user);
                    }

                }
            }
        } catch (Exception e) {
            log.error("环信注册失败 userId: {}", user, e);
        }
    }*/

    /*public boolean syncEs(User user, Boolean isThirdPart) {
        // 这里要再查一次是因为user做update时只会传修改了的字段，
        // 其他未修改的字段为null，所以会把es里未修改的字段全部置为null
        //有部分字段只存在es，这里需要同步一下
        UserDoc userDoc = new UserDoc();
        User userDb = findById(user.getId());
        UserDoc esDoc = getUserDocById(user.getId());
        BeanUtil.copyProperties(user, userDb, CopyOptions.create().setIgnoreNullValue(true));
        BeanUtil.copyProperties(userDb, userDoc);
        userDoc.setGenderUpdatable(isThirdPart);
        if (esDoc != null) {
            userDoc.setSameCity(esDoc.getSameCity());
            userDoc.setShowLocation(esDoc.getShowLocation());
            userDoc.setShowInTops(esDoc.getShowInTops());
            userDoc.setShowInRoom(esDoc.getShowInRoom());
        }
        userDoc.setImId(user.getImId());
        log.info("更新用户索引 userDoc: {}", userDoc);
        return userSearchComponent.saveIndex(userDoc);
    }*/

    /*public User findById(Integer userId) {
        if (userId == null) {
            return null;
        }
        User user = userService.findById(userId);
        if (user == null) {
            return null;
        }
        UserAccount userAccount = userAccountService.findByUserIdAndType(user.getId(), UserAccountTypeEnum.getTypeBySource(user.getSourceId()));
        if (userAccount != null) {
            user.setOpenId(userAccount.getOpenId());
            user.setUnionId(userAccount.getUnionId());
        }
        return user;
    }*/

    /*public UserDoc getUserDocById(Integer userId) {
        List<UserDoc> userDocs = null;
        UserSearchQueryBo userSearchQueryBo = new UserSearchQueryBo();
        userSearchQueryBo.setId(userId.toString());
        userDocs = userSearchComponent.findByUserBO(userSearchQueryBo);
        return !CollectionUtil.isEmpty(userDocs) ? userDocs.get(Constant.CONSTANT_ZERO) : null;
    }*/


}
