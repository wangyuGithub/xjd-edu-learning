package com.xjd.edu.service;

import com.xjd.edu.model.GamePrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

import static com.xjd.edu.config.AppConfig.*;
import static com.xjd.edu.enums.RedisKeyEnum.*;


/**
 * @author zlikun
 * @date 2022/2/15 18:59
 */
@Slf4j
@Service
public class TokenService {

    @Autowired
    private ReactiveStringRedisTemplate template;

    @Value("${config.evn.prefix}")
    private String prefix;

    private String getPrefix() {
        if (prefix.contains("PTS")) {
            return "PROD";
        }
        return prefix;
    }

    public Mono<GamePrincipal> get(String token) {
        if (!StringUtils.hasText(token)) {
            return Mono.empty();
        }

        return template.opsForHash()
                .multiGet(this.getTokenKey(token), Arrays.asList(PRINCIPAL_NAME_REDIS_FIELD, RENEW_TIMESTAMP_REDIS_FIELD))
                .filter(items -> !CollectionUtils.isEmpty(items) && items.get(0) != null)
                .map(items -> {
                    final GamePrincipal principal = new GamePrincipal((String) items.get(0));
                    if (items.size() > 1 && items.get(1) != null) {
                        principal.setRenewTimestamp(Long.parseLong((String) items.get(1)));
                    }
                    return principal;
                });
    }

    /**
     * 续租逻辑
     *
     * @param token     续租Token
     * @param principal 认证主体
     * @return
     */
    public Mono<Void> renew(String token, GamePrincipal principal) {

        if (!StringUtils.hasText(token) || principal == null) {
            return Mono.empty();
        }

        // 时间间隔小于1天不执行续租
        if (System.currentTimeMillis() - principal.getRenewTimestamp() < RENEW_INTERVAL_MS) {
            return Mono.empty();
        }

        // 续租逻辑：1. Token本身续租 2. 更新续租时间戳 3. 用户映射续租
        final String key = this.getTokenKey(token);
        log.info("Renew Token -> principal: {}, token: {}, key: {}", principal, token, key);
        return Flux.merge(
                template.expire(key, TOKEN_DURATION),
                template.opsForHash().put(key, RENEW_TIMESTAMP_REDIS_FIELD, String.valueOf(System.currentTimeMillis())),
                template.expire(this.getUserMappingKey(principal.getName()), TOKEN_DURATION)
        ).then();
    }

    /**
     * 皮皮后台定制逻辑（后台没有续租逻辑）
     *
     * @param token
     * @return
     */
    public Mono<GamePrincipal> getAdmin(String token) {
        if (!StringUtils.hasText(token)) {
            return Mono.empty();
        }

        return template.opsForHash()
                .multiGet(this.getAdminTokenKey(token), Arrays.asList(PRINCIPAL_NAME_REDIS_FIELD, STATUS_REDIS_FIELD))
                .filter(items -> !CollectionUtils.isEmpty(items) && items.get(0) != null)
                .map(items -> {
                    final GamePrincipal principal = new GamePrincipal((String) items.get(0));
                    if (items.size() > 1 && items.get(1) != null) {
                        // 兼容：非启用即为禁用（包含状态未正常设置情形）
                        if (Integer.parseInt(items.get(1).toString()) != ENABLE) {
                            log.warn("管理员 {} 已被禁用", principal.getName());
                            return null;
                        }
                    }
                    return principal;
                });
    }

    /**
     * Token 缓存键，示例：PROD-PLAY_TOKEN-APP-f7ebcf177ba74c88a2e264878c7dc675#36
     *
     * @param token
     * @return
     */
    private String getTokenKey(String token) {
        return String.format("%s-%s-%s", getPrefix(), PLAY_TOKEN.name(), token);
    }

    /**
     * 用户（映射）缓存键，示例：PROD:GAME_APP_TOKEN_MAPPING:36
     *
     * @param id
     * @return
     */
    private String getUserMappingKey(String id) {
        return String.format("%s:%s:%s", getPrefix(), GAME_APP_TOKEN_MAPPING.name(), id);
    }

    /**
     * 针对皮皮后台的登录Token缓存键，示例：PROD-ADMIN_TOKEN-******
     *
     * @param token
     * @return
     */
    private String getAdminTokenKey(String token) {
        return String.format("%s-%s-%s", getPrefix(), ADMIN_TOKEN.name(), token);
    }

}
