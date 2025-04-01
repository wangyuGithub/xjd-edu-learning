package com.xjd.edu.config;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
@Component(value = "anon-url")
@ConfigurationProperties(prefix = "config")
public class AnonymousConfig {

    private List<String> anonUrl = new ArrayList<>();

}
