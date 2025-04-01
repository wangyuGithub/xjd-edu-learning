package com.xjd.edu.common.dict;

import cn.hutool.core.map.MapUtil;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.xjd.edu.common.Constant;
import com.xjd.edu.common.config.SystemConfig;
import com.xjd.edu.common.entity.DictItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.util.*;
import java.util.function.Supplier;

/**
 * 字典服务本地缓存实现
 *
 * @author zlikun
 * @date 2021/09/18 10:28
 */
@Slf4j
public class LocalDictService implements DictService {

    // 字典缓存同步任务周期60s
    private static final Duration LOCAL_CACHE_DURATION = Duration.ofSeconds(30);
    // 缓存条目上限（目前字典 dict_code 共计225个）
    private static final int CACHE_MAXIMUM_SIZE = 1024;
    // 本地缓存
    private LoadingCache<String, Map<String, DictItem>> CACHE;

    private RedisTemplate redisTemplate;
    private SystemConfig systemConfig;

    public LocalDictService(RedisTemplate redisTemplate, SystemConfig systemConfig) {
        this.redisTemplate = redisTemplate;
        this.systemConfig = systemConfig;
    }

    @PostConstruct
    public void init() {
        CACHE = Caffeine.newBuilder()
                .maximumSize(CACHE_MAXIMUM_SIZE)
                .expireAfterWrite(LOCAL_CACHE_DURATION)
                .build(new CacheLoader<String, Map<String, DictItem>>() {

                    @Nullable
                    @Override
                    public Map<String, DictItem> load(@NonNull String dictCode) throws Exception {
                        return redisTemplate.boundHashOps(Constant.dictRedisKey(dictCode)).entries();
                    }
                });
    }

    private Map<String, DictItem> find0(@NotNull String dictCode) {
        Map<String, DictItem> dictItemMap = CACHE.get(dictCode);
        String env = systemConfig.getEnv().getPrefix();
        // 如果是预发环境
        if (StringUtils.equalsIgnoreCase("PRE", env)) {
            dictItemMap.forEach((k, v) -> {
                if (StringUtils.isNotBlank(v.getGrayVal())) {
                    v.setVal(v.getGrayVal());
                }
            });
        }
        return dictItemMap;
    }

    @Override
    public DictItem find(@NotNull String dictCode, @NotNull String itemCode) {
        DictItem dictItem = null;
        if (Objects.isNull(dictItem)) {
            dictItem = MapUtil.get(this.find0(dictCode), itemCode, DictItem.class);
        }
        return dictItem;
    }

    @Override
    public List<DictItem> find(@NotNull String dictCode) {
        final Map<String, DictItem> items = this.find0(dictCode);
        if (CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }
        return new ArrayList<>(items.values());
    }

}
