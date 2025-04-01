package com.xjd.edu.common.enums;

import cn.hutool.core.util.ObjectUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author zlikun
 * @see HostTypeEnum
 * @since 2022/4/13
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AppType {

    PI_PI("皮皮", 1, "pipipeiwan","com.chudiangameplay.android"),
    PLAYMATE("理想玩伴", 2, "idealplaymate","com.idealplaymate.lxwb"),
    ;

    private final String name;
    private final int value;
    private final String ua;
    private final String pkgName;

    public static AppType of(Integer type) {
        return Arrays.stream(AppType.values()).filter(at -> ObjectUtil.equal(at.value, type)).findFirst().orElse(null);
    }

//    public static Optional<AppType> of(String name) {
//        return Arrays.stream(AppType.values()).filter(at -> ObjectUtil.equal(at.name,name)).findFirst();
//    }

//    public static Optional<AppType> of(ClientInfo clientInfo) {
//        return Optional.ofNullable(clientInfo).map(ClientInfo::getAppType);
//    }

    public static AppType of(HostTypeEnum hostType) {
        if (hostType == null) {
            return null;
        }
        switch (hostType) {
            case APP:
            //case APP_V2:
            case H5:
                return AppType.PI_PI;
//            case APP_PLAYMATE:
//            case H5_PLAYMATE:
//                return AppType.PLAYMATE;
            default:
                return null;
        }
    }

    public boolean isPresent(Integer appType) {
        return ObjectUtil.equal(this.getValue(), appType);
    }

//    public boolean isPresent(ClientInfo clientInfo) {
//        return ObjectUtil.equal(Optional.ofNullable(clientInfo).map(ClientInfo::getAppType).map(AppType::getValue).orElse(null), this.getValue());
//    }

}
