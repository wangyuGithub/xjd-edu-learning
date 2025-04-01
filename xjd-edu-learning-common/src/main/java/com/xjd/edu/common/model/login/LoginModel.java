package com.xjd.edu.common.model.login;

import com.xjd.edu.common.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zsw
 * @description:
 * @date 2021-01-18 15:46:57
 */
@Data
public class LoginModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 验证码
     */
    private String code;

    /**
     * 验证码 - uuid
     */
    private String uuid;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 一键登入app端SDK获取的登录token
     */
    private String accessToken;

    /**
     *
     */
    private ThirdPartyLogin thirdPartyLogin;


    //private ClientInfo clientInfo;

    private String ip;

    private String keyword;

    private Date searchTime;

    private Integer type;

    private String openId;

    private Integer loginType;

    private String verifyCode;

    private boolean encrypt;

    //private AccountBindDTO accountBindDTO;

    /* ========== 控制台 =========== */
    private String username;

    private String password;

    private String captcha;

    private Integer hostType;

    /* =========== 绑定多账号 =========== */

    // 设备凭证
    private String deviceCert;

    /* =========== 多账号快捷登录 =========== */
    private User user;


}
