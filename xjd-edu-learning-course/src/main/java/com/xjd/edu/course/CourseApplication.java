package com.xjd.edu.course;

import com.xjd.edu.toolkit.cache.annotation.EnableDefaultRedis;
import com.xjd.edu.toolkit.cache.annotation.EnableRedisson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableFeignClients(value = "com.xjd.edu")
@ComponentScan(value = "com.xjd.edu")
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableDefaultRedis
@EnableRedisson
@SpringBootApplication
@EnableDiscoveryClient
public class CourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class, args);
    }
}
