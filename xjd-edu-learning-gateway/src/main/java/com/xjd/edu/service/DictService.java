package com.xjd.edu.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.xjd.edu.model.DictItem;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zlikun
 * @created 2022/2/15 19:04
 */
@Slf4j
@Service
public class DictService {

    @Autowired
    private StringRedisTemplate template;

    private static final String DICT_REDIS_KEY_PREFIX = "app:dict:items:";

    // 字典缓存同步任务周期60s
    private static final Duration LOCAL_CACHE_DURATION = Duration.ofSeconds(60);
    // 缓存条目上限，目前实际只有2条(APP | H5)
    private static final int CACHE_MAXIMUM_SIZE = 16;

    // 本地缓存
    private LoadingCache<String, Map<String, DictItem>> CACHE;

    @PostConstruct
    public void init() {
        CACHE = Caffeine.newBuilder()
                .maximumSize(CACHE_MAXIMUM_SIZE)
                .expireAfterWrite(LOCAL_CACHE_DURATION)
                .build(new CacheLoader<String, Map<String, DictItem>>() {

                    @Nullable
                    @Override
                    public Map<String, DictItem> load(@NonNull String dictCode) throws Exception {
                        final Map<Object, Object> data = template.boundHashOps(dictRedisKey(dictCode)).entries();
                        if (CollectionUtils.isEmpty(data)) {
                            return null;
                        }

                        return data.entrySet()
                                .stream()
                                .collect(Collectors.toMap(e -> (String) e.getKey(), e -> {
                                    final String value = (String) e.getValue();
                                    if (StringUtils.hasText(value)) {
                                        return JSONUtil.toBean(StrUtil.sub(value, value.indexOf("{"), value.lastIndexOf("}") + 1), DictItem.class);
                                    }
                                    return new DictItem();
                                }));
                    }
                });
    }

    public DictItem find(@NotNull String dictCode, @NotNull String itemCode) {
        final Map<String, DictItem> data = this.find0(dictCode);
        if (CollectionUtils.isEmpty(data)) {
            return null;
        }
        return data.get(itemCode);
    }

    public List<DictItem> find(@NotNull String dictCode) {
        final Map<String, DictItem> items = this.find0(dictCode);
        if (CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }
        return new ArrayList<>(items.values());
    }

    private String dictRedisKey(String dictCode) {
        return String.format("%s%s", DICT_REDIS_KEY_PREFIX, dictCode);
    }

    private Map<String, DictItem> find0(@NotNull String dictCode) {
        return CACHE.get(dictCode);
    }

}
