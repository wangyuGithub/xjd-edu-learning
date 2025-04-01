package com.xjd.edu.user.config;

import com.xjd.edu.user.interceptor.ClientInfoInterceptorAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public ClientInfoInterceptorAdapter clientInfoInterceptor() {
        return new ClientInfoInterceptorAdapter();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(clientInfoInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/actuator/**", "/error", "/api/v1/health", "/user/login");
    }

}
