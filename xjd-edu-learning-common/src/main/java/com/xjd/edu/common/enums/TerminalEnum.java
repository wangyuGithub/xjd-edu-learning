package com.xjd.edu.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
/**
 * 该枚举类型TerminalEnum不允许持久化，只能在进程中使用
 *
 * @function 终端类型
 * @date 2018年11月23日 下午5:11:57
 * @author 李桥
 * @version 1.0
 */
public enum TerminalEnum implements TypeEnum<Integer> {
    /**
     * H5_PC
     */
    H5_PC(-1, "H5_PC"),
    /**
     * H5_MOBILE
     */
    H5_MOBILE(-2, "H5_MOBILE"),
    /**
     * DEFAULT
     */
    DEFAULT(-3, "DEFAULT"),
    /**
     * 小程序
     */
    PLAY(1, "小程序"),
    /**
     * IOS
     */
    IOS(4, "IOS"),
    /**
     * ANDROID
     */
    ANDROID(5, "ANDROID"),
    /**
     * IOS或者ANDROID
     */
    APP(45, "APP(android+ios)");

    private Integer type;
    private String msg;

    public static TerminalEnum getEnumByType(Integer type) {
        for (TerminalEnum platformEcoEnum : TerminalEnum.values()) {
            if (platformEcoEnum.getType().equals(type)) {
                return platformEcoEnum;
            }
        }
        throw new IllegalArgumentException("{" + type + "}平台不匹配");
    }

    public static String getMsgByType(Integer type) {
        for (TerminalEnum ecoEnum : TerminalEnum.values()) {
            if (ecoEnum.type.equals(type)) {
                return ecoEnum.msg;
            }
        }
        return null;
    }

    @Override
    public TypeEnum<Integer> parse(Integer type) {
        for (TerminalEnum e : TerminalEnum.values()) {
            if (Objects.equals(e.getType(), type)) {
                return e;
            }
        }
        return null;
    }

}
