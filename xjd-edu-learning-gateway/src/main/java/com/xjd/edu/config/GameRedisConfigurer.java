package com.xjd.edu.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * 推荐使用 ReactiveStringRedisTemplate 和 StringRedisTemplate 即不作序列化处理（字节直接转换为字符串）
 *
 * @author zlikun
 * @date 2022/2/22 11:24
 * @see org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
 * @see org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration
 */
@Slf4j
@Configuration
public class GameRedisConfigurer {

    // 注：禁止使用 RedisTemplate<Object, Object> （目前未作配置，实际使用JDK序列化），推荐使用 StringRedisTemplate
    // 注：禁止使用 ReactiveRedisTemplate<Object, Object> （目前未作配置，实际使用JDK序列化），推荐使用 ReactiveStringRedisTemplate

}
