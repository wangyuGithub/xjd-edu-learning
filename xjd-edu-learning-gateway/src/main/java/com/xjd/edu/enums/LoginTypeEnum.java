package com.xjd.edu.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author zsw
 * @description:
 * @date 2021-01-22 13:48:08
 */
@AllArgsConstructor
@Getter
public enum LoginTypeEnum {

    MOBILE_VERIFY(1, "手机号验证码登录"),
    MOBILE_ONE_CLICK(20, "手机号一键登录"),
    THIRD_PART_WECHAT_APP(2, "微信APP登录"),
    THIRD_PART_QQ(3, "QQ登录"),
    THIRD_PART_APPLE(10, "苹果一键登录"),
    THIRD_PART_WECHAT_MP(40, "微信H5登录"),
    THIRD_PART_WECHAT_MINI_PROGRAME(5, "微信小程序登录"),
    BAIDU_SMART_PROGRAM(63, "百度-智能小程序"),
    ;

    private Integer key;
    private String value;

    public static LoginTypeEnum getByKey(Integer key) {
        return Arrays.stream(values()).filter(e -> Objects.equals(e.getKey(), key)).findFirst().orElse(null);
    }
}
