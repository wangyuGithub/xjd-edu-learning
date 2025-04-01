package com.xjd.edu.common.utils;

import com.xjd.edu.common.entity.User;
import com.xjd.edu.common.enums.TerminalEnum;
import com.xjd.edu.common.service.TokenService;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取和设置当前登录用户对象数据
 */
public class SubjectUtil {

    private static TokenService tokenService;

    private static final ThreadLocal<TerminalEnum> terminal = new ThreadLocal<TerminalEnum>();
    private static final ThreadLocal<Object> userTl = ThreadLocal.withInitial(() -> null);

    private static final ThreadLocal<Object> adminTl = new ThreadLocal<>();
    private static final ThreadLocal<String> token = ThreadLocal.withInitial(() -> null);

    /**
     * 优化：原则上认证只记录用户ID（保留Token是为了兼容原有代码逻辑），查询登录用户信息采用懒加载模式，避免不必要的用户查询操作
     */
    private static final ThreadLocal<Integer> userIdTl = new ThreadLocal<>();

    private static final ThreadLocal<String> ip = new ThreadLocal<>();

    /**
     * 初始化工具类，用于注入 TokenService 实例
     *
     * @param tokenService
     */
    public static void init(TokenService tokenService) {
        SubjectUtil.tokenService = tokenService;
    }

    /**
     * 如果只需要登录用户ID，推荐直接使用 #getCurrentUserId() 方法
     *
     * @return
     */
    public static Object getCurrentUser() {
        return userTl.get();
    }

    public static void setCurrentUser(Object o) {
        userTl.set(o);
    }

    public static Object getCurrentAdmin() {
        return adminTl.get();
    }

    public static void setCurrentAdmin(Object o) {
        adminTl.set(o);
    }

    public static String getToken() {
        return token.get();
    }

    public static void setToken(String genToken) {
        token.set(genToken);
    }

    public static void setTokenAndUser(String gToken, Object user) {
        SubjectUtil.setToken(gToken);
        SubjectUtil.setCurrentUser(user);

    }

    public static void clearTokenAndUser() {
        token.remove();
        userTl.remove();
        userIdTl.remove();
        terminal.remove();
    }

    public static String getIp() {
        return ip.get();
    }

    public static void setIp(String ipStr) {
        ip.set(ipStr);
    }

    public static TerminalEnum getTerminalEnum() {
        return terminal.get();
    }

    public static void setTerminalEnum(TerminalEnum terminalEnum) {
        terminal.set(terminalEnum);
    }

    public static Integer getTokenUserId(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        try {
            // 创建 Pattern 对象
            Pattern r = Pattern.compile(".+#(\\d+)");
            // 现在创建 matcher 对象
            Matcher m = r.matcher(token);
            if (m.matches()) {
                return Integer.valueOf(m.group(1));
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 设置登录用户ID
     *
     * @param userId
     */
    public static void setCurrentUserId(int userId) {
        userIdTl.set(userId);
    }

    /**
     * 获取登录用户ID
     *
     * @return
     */
    public static Integer getCurrentUserId() {
        Integer userId = userIdTl.get();
        // 处理发版过程中的兼容问题（后发Gateway，所以可能没有 X-Auth-Id 值，通过原逻辑来初始化登录用户ID值）
        if (userId == null) {
            final User user = (User) getCurrentUser();
            if (user != null) {
                userId = user.getId();
                setCurrentUserId(userId);
            }
        }
        return userId;
    }
}
