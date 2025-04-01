package com.xjd.edu.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 业务类型枚举
 */
@AllArgsConstructor
@Getter
public enum HostTypeEnum {
    H5(1, "H5", "h5"),
    APP(2, "APP", "app"),
    SYS_ADMIN(3, "system控制台", "sysAdmin"),
    DX_ADMIN(4, "督学端控制台", "dxAdmin"),
    DXM_ADMIN(5, "督学端管理端控制台", "dxmAdmin"),
    ;

    private Integer type;
    private String msg;
    private String key;


    public static HostTypeEnum findByKey(String key) {
        return Arrays.stream(values())
                .filter(e -> Objects.equals(e.getKey(), key))
                .findFirst()
                .orElse(null);
    }

    public static HostTypeEnum findByType(Integer type) {
        return Arrays.stream(values())
                .filter(e -> Objects.equals(e.getType(), type))
                .findFirst()
                .orElse(null);
    }

}
