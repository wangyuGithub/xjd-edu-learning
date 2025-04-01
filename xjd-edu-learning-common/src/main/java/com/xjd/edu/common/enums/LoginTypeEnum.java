package com.xjd.edu.common.enums;

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
    THIRD_PART_WECHAT_MP(40, "微信H5登录"),
    THIRD_PART_WECHAT_MINI_PROGRAME(5, "微信小程序登录"),
    BAIDU_SMART_PROGRAM(63, "百度-智能小程序"),
    SWITCH_ACCOUNT_QUICK_LOGIN(64, "切换账号快捷登录"),
    THIRD_PART_WECHAT_APP_PLAYMATE(42, "理想玩伴微信APP登录"),
    THIRD_PART_WECHAT_MP_PLAYMATE(46, "理想微信公众号登录"),
    ;

    private Integer key;
    private String value;

    public static LoginTypeEnum getByKey(Integer key) {
        return Arrays.stream(values()).filter(e -> Objects.equals(e.getKey(), key)).findFirst().orElse(null);
    }
}
