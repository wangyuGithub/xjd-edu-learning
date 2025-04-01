package com.xjd.edu.common.model.login;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ThirdPartyLogin {

    //校验token
    @NotNull(message = "[accessToken]字段不能为空")
    private String accessToken;

    @NotNull(message = "[openId]字段不能为空")
    private String openId;

    private String unionId;

    //登录类型 2:微信 3:QQ 10:apple
    @NotNull(message = "[loginType]字段不能为空")
    private Integer loginType;

    //头像
    private String headPortraitsUrl;
    //昵称
    private String nickname;
    //性别
    private Integer gender;

    private String ip;

    @NotNull(message = "[timestamp]字段不能为空")
    private String timestamp;

    @NotNull(message = "[sign]字段不能为空")
    private String sign;

    private String code;

    private String keyword;

    private Date searchTime;

    /**
     * 是否需要审核
     */
    private Integer type;
}
