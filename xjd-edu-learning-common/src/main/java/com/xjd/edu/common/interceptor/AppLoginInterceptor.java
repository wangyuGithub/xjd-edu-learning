package com.xjd.edu.common.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjd.edu.common.Constant;
import com.xjd.edu.common.RequestUtil;
import com.xjd.edu.common.config.HostConfig;
import com.xjd.edu.common.entity.User;
import com.xjd.edu.common.service.TokenService;
import com.xjd.edu.common.utils.SubjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * App登录拦截器，处理登录用户信息、设备信息、风控等
 *
 * @author zlikun
 * @created 2022/1/10 16:49
 */
@Slf4j
public class AppLoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ObjectMapper mapper;

    final Base64.Decoder decoder = Base64.getDecoder();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 请求URI
        final String uri = request.getRequestURI();
        // 获取Query参数
        final Map<String, String> paramMap = RequestUtil.getParamerterMap(request);
        // 获取Header中的 X-Client-Info 值（JSON），Header中的值优先级高于Query参数中的
        paramMap.putAll(getClientInfoFromHeader(request));
        paramMap.put("_ip", RequestUtil.getIpAdrress(request));
        // 获取设备信息
        int appType = request.getIntHeader("X-App-Type");
        if (log.isDebugEnabled()) {
            log.debug("X-App-Type :{}", appType);
        }
        // 移除设备信息部分（下划线开头）
        paramMap.entrySet().removeIf(item -> item.getKey().startsWith("_"));
        // 获取登录Token信息，进入该拦截器请求都必须是登录状态
        final String token = request.getHeader(Constant.LOGIN_TOKEN);
        String ip = RequestUtil.getIpAdrress(request);
        // 由于目前该拦截器针对所有请求拦截，请求实际是可能不携带 Token 的，因此作空值判断
        if (StringUtils.hasText(token)) {
            // 设置登录用户（ThreadLocal），因为网关层已校验过Token有效性，这里不再重复校验
            this.setCurrentUser(request, token).ifPresent(user -> {
                // 打印访问日志
                if (log.isDebugEnabled()) {
                    log.debug("请求（已登录） uri: {}, token: {}, params: {}, user: {}", uri, token, paramMap, user);
                }
            });
        }
        return super.preHandle(request, response, handler);
    }


    /**
     * 清除登录状态，避免线程池线程被复用情况下的一些极端情况，如：请求1登录过、请求2未登录，但复用了请求1的线程，从而从ThreadLocal中取得了前者的用户信息
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (SubjectUtil.getCurrentUser() != null) {
            SubjectUtil.clearTokenAndUser();
        }
    }

    private Map<String, String> getClientInfoFromHeader(HttpServletRequest request) {
        final String s = request.getHeader("X-Client-Info");
        if (log.isDebugEnabled()) {
            log.debug("uri: {}, clientInfo: {}", request.getRequestURI(), s);
        }
        if (!StringUtils.hasText(s)) {
            return Collections.emptyMap();
        }
        try {
            return mapper.readValue(decoder.decode(s), new TypeReference<Map<String, String>>() {
            });
        } catch (Exception e) {
            log.error("Header指定的ClientInfo信息 {} 格式错误", s, e);
            return Collections.emptyMap();
        }
    }

    /**
     * 设置当前用户，返回用户ID
     *
     * @param request
     * @param token
     * @return
     */
    protected Optional<User> setCurrentUser(HttpServletRequest request, String token) {

        SubjectUtil.setToken(token);
        Integer userId;

        // 检查消息头中是否携带 X-Auth-Id （认证用户ID）
        final String authId = request.getHeader(Constant.X_AUTH_ID);

        if (StringUtils.hasText(authId)) {
            if (log.isDebugEnabled()) {
                log.debug("调试代码 - X-Auth-Id: {}, token: {}", authId, token);
            }
            // 上游指定的认证用户ID，不必再查询Redis，直接使用
            userId = Integer.parseInt(authId);
        } else {
            // 上游未指定时，通过Token值获取用户ID
            userId = SubjectUtil.getTokenUserId(token);
            if (log.isDebugEnabled()) {
                log.debug("调试代码 - userId: {}, token: {}", userId, token);
            }
        }

        if (userId != null) {
            SubjectUtil.setCurrentUserId(userId);
//            return Optional.of(userId);
        }

        // 暂时仍直接获取用户信息（目前存在用户不停变化的问题，待处理）
        // 查询登录用户信息
        final Map<String, Object> map = tokenService.getUserMap(token);
        // Token绑定用户信息为空，清除本地登录状态
        if (CollectionUtils.isEmpty(map)) {
            log.warn("无效登录 Token {}", token);
            SubjectUtil.clearTokenAndUser();
            return Optional.empty();
        }

        // 转换Map为Bean（登录用户）
        final User user = BeanUtil.mapToBean(map, User.class, Boolean.TRUE);

        // 设置登录用户和Token信息（ThreadLocal）
        SubjectUtil.setCurrentUser(user);

        // 排查问题
        if (userId != null && !user.getId().equals(userId)) {
            log.warn("通过 X-Auth-Id 传入的用户ID与Token查出的用户不一致 token: {} authId: {} userId: {}", token, userId, user.getId());
        }

        return Optional.of(user);
    }


    /**
     * 获取当前登录用户
     *
     * @return
     */
    protected Optional<User> getCurrentUser() {
        return Optional.ofNullable((User) SubjectUtil.getCurrentUser());
    }

}
