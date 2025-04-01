package com.xjd.edu.common.config;

import com.xjd.edu.common.component.Slf4jMdcFilter;
import com.xjd.edu.common.service.impl.TokenServiceImpl;
import com.xjd.edu.common.utils.SubjectUtil;
import com.xjd.edu.toolkit.cache.GameRedisTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.env.StandardEnvironment;

import javax.servlet.Filter;

/**
 * 统一管理 common 项目中 Bean 注册
 * <p>
 * 这里通过 META-INF/spring.factories 文件来进行自动装配（否则 @AutoConfigureOrder 注解不生效），
 * 指定顺序的原因是 RedisTemplate 等应先于本配置类初始化，否则 @ConditionalOnBean 会因为检查的时候目标Bean不存在而误判
 *
 * @author zlikun
 * @created 2021/12/16 13:34
 */
@Slf4j
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
@Import(CommonAutoConfiguration.CommonServletFilterConfiguration.class)
public class CommonAutoConfiguration {

//    @Bean
//    @ConditionalOnBean(RedisTemplate.class)
//    public LocalDictService localDictService(RedisTemplate redisTemplate, SystemConfig systemConfig) {
//        return new LocalDictService(redisTemplate, systemConfig);
//    }


    @Bean
    @ConditionalOnBean(GameRedisTemplate.class)
    public TokenServiceImpl tokenService() {
        final TokenServiceImpl tokenService = new TokenServiceImpl();
        SubjectUtil.init(tokenService); // 注入 TokenService 实例
        return tokenService;
    }

//    @Bean
//    @ConditionalOnBean(RedisTemplate.class)
//    @ConditionalOnProperty(value = "config.bloom.device.enabled", matchIfMissing = true)
//    public RedisBloomFilter redisBloomFilter() {
//        return new RedisBloomFilter();
//    }

    /**
     * 设备号布隆过滤器
     *
     * @return
     */
//    @Bean
//    @ConditionalOnProperty(value = "config.bloom.device.enabled", matchIfMissing = true)
//    public BloomFilterHelper deviceNoBloomFilter() {
//        log.info("初始化设备号布隆过滤器");
//        return new BloomFilterHelper<>(Funnels.stringFunnel(Charset.defaultCharset()), 50000000, 0.01);
//    }

//    @Bean
//    @ConditionalOnBean({RedisTemplate.class, DictService.class})
//    public SMSCodeUtil smsCodeUtil(RedisTemplate redisTemplate, DictService dictService) {
//        return new SMSCodeUtil(redisTemplate, dictService);
//    }
    /**
     * Http Servlet Filter 配置类（解决限定条件不生效问题）
     */
    @ConditionalOnClass(name = "javax.servlet.Filter")
    static class CommonServletFilterConfiguration {

        @Bean
        public FilterRegistrationBean<Filter> slf4jMdcFilterRegistrationBean(StandardEnvironment environment) {
            final FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
            bean.setFilter(new Slf4jMdcFilter(environment));
            bean.setName("slf4j");
            bean.addUrlPatterns("/*");
            bean.setOrder(Integer.MIN_VALUE);
            return bean;
        }

    }
}
