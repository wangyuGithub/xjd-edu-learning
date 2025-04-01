package com.xjd.edu.common.config;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Component("systemConfigProperties")
@Accessors(chain = true)
@ConfigurationProperties(prefix = "system")
@Data
@Slf4j
@Validated
public class SystemConfig {

    private Env env = new Env();

    @Data
    public static class Env {
        private String prefix;
    }
}
