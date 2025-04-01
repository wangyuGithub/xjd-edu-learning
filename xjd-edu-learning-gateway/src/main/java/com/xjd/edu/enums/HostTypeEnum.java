package com.xjd.edu.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum HostTypeEnum {
    H5(1, "H5", "h5"),
    APP(2, "APP", "app"),
    APP_V2(3, "APP", "app"),
    PIPI_ADMIN(5, "pipi控制台", "pipiAdmin"),
    GUILD(9, "公会中心", "guildCenter"),
    APP_PLAYMATE(10, "理想玩伴", "appPlaymate"),
    H5_PLAYMATE(11, "理想玩伴", "h5Playmate"),
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
