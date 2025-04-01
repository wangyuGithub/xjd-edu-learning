package com.xjd.edu.user.controller.login.auth;

import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.Lists;
import com.xjd.edu.common.enums.HostTypeEnum;
import com.xjd.edu.common.enums.RedisKeyEnum;
import com.xjd.edu.common.model.login.LoginModel;
import com.xjd.edu.common.model.login.LoginResult;
import com.xjd.edu.common.utils.GenIdUtil;
import com.xjd.edu.common.utils.StringUtils;
import com.xjd.edu.toolkit.cache.GameRedisTemplate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zsw
 * @description:
 * @date 2021-01-14 18:03:09
 */
@Component
@Slf4j
public class SystemAdminAuthentication extends AbsAuthentication {

    private static final String SESSION_CAPTCHA = "captcha";
    private static final int LOGIN_EXPIRE = 60 * 60;

    @Autowired
    private GameRedisTemplate gameRedisTemplate;


    @Value("${config.evn.prefix}")
    private String pre;

    @Override
    public List<HostTypeEnum> type() {
        return Lists.newArrayList(HostTypeEnum.SYS_ADMIN);
    }

    @SneakyThrows
    @Override
    public LoginResult login(LoginModel loginModel, HostTypeEnum hostTypeEnum) {

        return null;
    }

    public String generateKey(RedisKeyEnum redisKeyEnum, String id) {
        return pre + RedisKeyEnum.SPLIT + redisKeyEnum.name() + RedisKeyEnum.SPLIT + id;
    }

}
