package com.xjd.edu.user.controller.login.auth;

import com.xjd.edu.common.enums.HostTypeEnum;
import com.xjd.edu.common.exception.LoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author zsw
 * @description:
 * @date 2021-01-18 11:32:57
 */
@Component
@Slf4j
public class AuthenticationFactory implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (AuthenticationFactory.applicationContext == null) {
            AuthenticationFactory.applicationContext = applicationContext;
        }
    }

    public AbsAuthentication getInstance(HostTypeEnum typeEnum) {
        if (typeEnum == null) {
            log.info("获取鉴权操作类类型不能为空");
            throw new LoginException(LoginException.ExceptionCode.LOGIN_TYPE_NULL);
        }
        Optional<AbsAuthentication> optional = applicationContext
                .getBeansOfType(AbsAuthentication.class)
                .values()
                .stream()
                .filter(e -> e.type().contains(typeEnum))
                .findFirst();
        if (!optional.isPresent()) {
            log.error("当前业务类型不存在:{}", typeEnum);
            throw new LoginException(LoginException.ExceptionCode.LOGIN_TYPE_NULL);
        }
        log.info("current host {}",typeEnum);
        return optional.get();
    }



}
