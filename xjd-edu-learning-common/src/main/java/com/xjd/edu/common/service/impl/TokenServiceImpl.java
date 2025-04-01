package com.xjd.edu.common.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSONObject;
import com.xjd.edu.common.entity.User;
import com.xjd.edu.common.enums.HostTypeEnum;
import com.xjd.edu.common.enums.RedisKeyEnum;
import com.xjd.edu.common.service.TokenService;
import com.xjd.edu.common.utils.GenIdUtil;
import com.xjd.edu.toolkit.cache.GameRedisTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.xjd.edu.common.Constant.APP_EXPIRE_TIME;
import static com.xjd.edu.common.enums.RedisKeyEnum.GAME_APP_TOKEN_MAPPING;

/**
 * App | H5 登录 Token 服务
 *
 * @Author libo
 * @date 2020/7/30 5:38 PM
 */
@Slf4j
public class TokenServiceImpl implements TokenService {

    @Autowired
    private GameRedisTemplate template;

    @Value("${config.evn.prefix}")
    private String prefix;

    // 统一过期时间：30days
    final Duration duration = Duration.ofSeconds(APP_EXPIRE_TIME);

    // 标记终端类型 HostTypeEnum#key
    final String HOST_TYPE_KEY = "_host_type";

//    // Renew Lua Script // 由于涉及多键，在阿里去Redis集群上存在跨 slot 问题，因此不能使用Lua脚本
//    final String RENEW_LUA_SCRIPT = "redis.call('PEXPIRE', KEYS[1], ARGV[1])\n" +
//            "local id = redis.call('HGET', KEYS[1], 'id')\n" +
//            "if id ~= nil then\n" +
//            "    redis.call('PEXPIRE', string.format('%s:GAME_APP_TOKEN_MAPPING:%s', KEYS[2], id), ARGV[1])\n" +
//            "end";

    /**
     * 创建用户 Token
     *
     * @param userMap
     * @param type
     * @return 返回 Token
     * @see #create(String, Map, HostTypeEnum)
     */
    private String create(Map<String, Object> userMap, HostTypeEnum type) {
        final String token = this.generateToken(type, (Integer) userMap.get("id"));
        this.create(token, userMap, type);
        return token;
    }

    /**
     * 创建用户 Token
     *
     * @param token
     * @param userMap
     * @param type
     */
    private void create(String token, Map<String, Object> userMap, HostTypeEnum type) {
        final Integer userId = (Integer) userMap.get("id");

        log.info("创建用户Token -> userId: {}, token: {}", userId, token);

        // 检查是否存在旧Token
        final Map<String, String> mappings = this.getTokenMappings(userId);
        // 创建新 Token 映射键会被覆盖，所以不必显示执行删除操作
        if (!CollectionUtils.isEmpty(mappings)) {
            // 查找到旧 Token 并执行删除
            final String deprecatedToken = mappings.get(type.getKey());
            if (StringUtils.hasText(deprecatedToken)) {
                log.warn("挤掉旧Token -> userId: {}, type: {}, new: {}, old: {}", userId, type, token, deprecatedToken);
                template.del(this.getTokenKey(deprecatedToken));
            }
        }

        // 记录终端类型
        userMap.put(HOST_TYPE_KEY, type);
        template.hmset(this.getTokenKey(token), userMap, duration);

        // 记录映射关系（如果已存在会被覆盖）
        template.hset(this.getUserKey(userId), type.getKey(), token, duration);
    }

    /**
     * 创建用户 Token
     *
     * @param user
     * @param type
     * @return
     * @see #create(Map, HostTypeEnum)
     */
    @Override
    public String create(User user, HostTypeEnum type) {
        Assert.notNull(user, "用户参数（User）不能为空");
        Assert.notNull(user.getId(), "用户ID不能为空");
        Assert.notNull(type, "终端类型（HostTypeEnum）参数不能为空");
        return this.create(BeanUtil.beanToMap(user), type);
    }

    /**
     * 根据 Token 获取用户ID
     *
     * @param token
     * @return
     */
    @Override
    public Integer getUserId(String token) {
        if (!StringUtils.hasText(token)) {
            return null;
        }
        return (Integer) template.hget(this.getTokenKey(token), "id").orElse(null);
    }

    /**
     * 根据 Token 获取用户数据
     *
     * @param token
     * @return
     */
    @Override
    public Map<String, Object> getUserMap(String token) {
        if (!StringUtils.hasText(token)) {
            return null;
        }
        final Map<String, Object> data = template.hgetall(this.getTokenKey(token));
        // 如果数据未标记 HOST_TYPE_KEY 字段（表示是存量数据），做一次数据迁移（Mapping）
//        if (!CollectionUtils.isEmpty(data) && !data.containsKey(HOST_TYPE_KEY)) {
//            // 因为不知道实际终端类型，将其标记为 App 如果实际是H5，后续重新登录App时会将H5的Token挤掉，是一个兼容策略
//            HostTypeEnum type = token.startsWith("H5") ? HostTypeEnum.H5 :
//                    token.startsWith("APP_PLAYMATE") ? HostTypeEnum.APP_PLAYMATE :
//                            token.startsWith("H5_PLAYMATE") ? HostTypeEnum.H5_PLAYMATE : HostTypeEnum.APP;
//            this.create(token, data, type);
//            log.warn("旧登录Token迁移 token: {}", token);
//        }
        return data;
    }

    /**
     * 更新 Token 用户（同步更新用户关联所有Token数据）
     *
     * @param userMap
     */
    private void update(Map<String, Object> userMap) {
        if (CollectionUtils.isEmpty(userMap) || !userMap.containsKey("id")) {
            return;
        }

        log.info("更新Token用户 -> user: {}", userMap);

        final Integer userId = (Integer) userMap.get("id");

        // 更新旧 Mapping 关联数据（旧版Mapping关联的是TokenKey） // TODO 保留到 2022/05/31 过后删除该逻辑，将不再支持旧版Token
        final Map<String, Object> deprecatedMappings = template.hgetall(this.getTokenMapperKey(userId));
        final Set<String> tokenKeys = new HashSet<>();
        if (!CollectionUtils.isEmpty(deprecatedMappings)) {
            log.warn("更新旧版 Token 用户信息 userId: {}", userId);
            tokenKeys.addAll(deprecatedMappings.keySet());
        }

        // 更新新 Mapping 关联数据
        final Map<String, String> mappings = this.getTokenMappings(userId);
        if (!CollectionUtils.isEmpty(mappings)) {
            log.info("更新新版 Token 用户信息 userId: {}", userId);
            // 查询命中，则更新全部 Token 用户数据（不续租，由用户访问时自动续租）
            final Set<String> newTokenKeys = mappings.values().stream().map(this::getTokenKey).collect(Collectors.toSet());
            newTokenKeys.forEach(key -> template.hmset(key, userMap));

            // 将旧 Mapping 中关联 Token 清除掉（新 Mapping 中重复部分除外）
            tokenKeys.removeAll(newTokenKeys);
            if (CollectionUtils.isEmpty(tokenKeys)) {
                template.del(tokenKeys);
            }
        }
    }

    @Override
    public void update(User user) {
        if (user == null || user.getId() == null) {
            return;
        }
        this.update(BeanUtil.beanToMap(user));
    }

    /**
     * 登出时只删除 Token 自身，其映射关系不作处理，后续自然过期或者重新登录时删除
     *
     * @param token
     */
    @Override
    public void delete(String token) {
        log.warn("删除TOKEN -> token: {}", token);
        template.del(this.getTokenKey(token));
    }

    /**
     * 清除用户登录状态（删除所有 Token，同时退出所有设备）
     *
     * @param userId
     */
    @Override
    public void clear(Integer userId) {
        if (userId == null) {
            return;
        }

        log.warn("清除用户TOKEN -> userId: {}", userId);

        // 清理旧 Mapping 关联 Token 数据  // TODO 保留到 2022/05/31 过后删除该逻辑，将不再支持旧版Token
        final String tokenMapperKey = this.getTokenMapperKey(userId);
        final Map<String, Object> deprecatedMappings = template.hgetall(tokenMapperKey);
        if (!CollectionUtils.isEmpty(deprecatedMappings)) {
            log.warn("清除旧版 Token 用户信息 userId: {}", userId);
            template.del(Stream.concat(deprecatedMappings.keySet().stream(), Stream.of(tokenMapperKey)).collect(Collectors.toSet()));
        }

        // 清理新 Mapping 关联 Token 数据
        final Map<String, String> mappings = getTokenMappings(userId);
        if (!CollectionUtils.isEmpty(mappings)) {
            log.info("清除新版 Token 用户信息 userId: {}", userId);
            Set<String> collectClear = Stream.concat(
                    mappings.values().stream().map(this::getTokenKey),
                    Stream.of(this.getUserKey(userId))
            ).collect(Collectors.toSet());
            log.info("清除新版 Token 用户信息明细信息 userId: {}, clear:{}, mappings:{}", userId, collectClear, mappings);
            template.del(Stream.concat(
                    mappings.values().stream().map(this::getTokenKey),
                    Stream.of(this.getUserKey(userId))
            ).collect(Collectors.toSet()));
        }

    }

    /**
     * 生成 Token
     *
     * @param type
     * @param userId
     * @return
     */
    private String generateToken(HostTypeEnum type, int userId) {
        return type.name() + "-" + GenIdUtil.GetTokenWithUserId(userId);
    }

//    /**
//     * PROD:GAME_APP_TOKEN:$token => $UserMap
//     * <br>
//     * 为保持兼容性（避免数据迁移），暂不使用该方法
//     *
//     * @param token
//     * @return
//     */
//    private String getTokenKey(String token) {
//        return GAME_APP_TOKEN.generateRedisKey(token);
//    }

    /**
     * PROD:GAME_APP_TOKEN_MAPPING:$userId => { app: $token ,h5: $token }
     *
     * @param userId
     * @return
     */
    private String getUserKey(int userId) {
        return GAME_APP_TOKEN_MAPPING.generateRedisKey(String.valueOf(userId));
    }

    /**
     * 根据token生成redis的key
     *
     * @param token
     * @return
     */
    private String getTokenKey(String token) {
        return RedisKeyEnum.PLAY_TOKEN.generateKey(token);
    }

    /**
     * 根据token生成redis的key
     *
     * @param token
     * @return
     */
    private String getAdminTokenKey(String token) {
        return RedisKeyEnum.ADMIN_TOKEN.generateKey(token);
    }

    /**
     * 根据用户id生成token mapper 的redis的key值
     *
     * @param userId
     * @return
     */
    private String getTokenMapperKey(int userId) {
        return RedisKeyEnum.PLAY_TOKEN_MAPPER.generateKey(userId);
    }

    /**
     * 查询 Token 映射信息 PROD:GAME_APP_TOKEN_MAPPING:$userId => { app: $token ,h5: $token, playmate: $token }
     *
     * @param userId
     * @return
     */
    private Map<String, String> getTokenMappings(int userId) {
        return Optional.ofNullable(template.hgetall(this.getUserKey(userId)))
                .orElse(Collections.emptyMap())
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (String) e.getValue()));
    }

    /**
     * 删除用户缓存信息
     */
    public void delLoginUser(String token) {
        if (StringUtils.hasText(token)) {
            template.del(getAdminTokenKey(token));
        }
    }
}
