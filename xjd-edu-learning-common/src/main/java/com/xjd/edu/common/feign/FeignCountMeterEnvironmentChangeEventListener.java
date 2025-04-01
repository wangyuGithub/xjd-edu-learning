package com.xjd.edu.common.feign;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * 当Feign监控配置发生变化时，清空计数器，避免造成内存溢出问题
 *
 * @author zlikun
 * @since 2023/2/6
 */
@Slf4j
@Component
public class FeignCountMeterEnvironmentChangeEventListener {

    static final String ALLOW_COUNT_PATH_KEY = "game.metrics.feign.allow_count_path";
    static final String METER_ID_NAME = "game.feign.requests";

    private final MeterRegistry registry;

    public FeignCountMeterEnvironmentChangeEventListener(MeterRegistry registry) {
        this.registry = registry;
    }

    @EventListener
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        if (event == null || CollectionUtils.isEmpty(event.getKeys()) || !event.getKeys().contains(ALLOW_COUNT_PATH_KEY)) {
            return;
        }

        for (Meter meter : registry.getMeters()) {
            if (METER_ID_NAME.equals(meter.getId().getName())) {
                registry.remove(meter);
            }
        }

        log.info("配置 {} 发生变更，清空自定义 Feign 请求计数器，重新开始计数", ALLOW_COUNT_PATH_KEY);
    }

}
