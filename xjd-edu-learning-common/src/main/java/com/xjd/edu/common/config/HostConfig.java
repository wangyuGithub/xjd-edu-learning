package com.xjd.edu.common.config;

import cn.hutool.core.bean.BeanUtil;
import com.xjd.edu.common.enums.HostTypeEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Component
@ConfigurationProperties(prefix = "config.host-config")
@Data
@Slf4j
public class HostConfig {
    private String h5;
    private String app;
    private String sysAdmin;
    private String dxAdmin;
    private String dxmAdmin;

    public HostTypeEnum getType(String host) {
        Map<String, Object> serviceMap = BeanUtil.beanToMap(this);
        AtomicReference<HostTypeEnum> result = new AtomicReference<>();
        serviceMap.forEach((k,v) -> {
            if (v == null) {
                return;
            }
            if (Arrays.asList(v.toString().split(",")).contains(host)) {
                result.set(HostTypeEnum.findByKey(k));
            }
        });
        return result.get();
    }
}
