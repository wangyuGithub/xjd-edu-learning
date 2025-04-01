package com.xjd.edu.common.model.login;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xjd.edu.common.entity.User;
import lombok.Data;

import java.util.Date;

/**
 * @author zsw
 * @description:
 * @date 2021-01-23 18:21:49
 */
@Data
public class LoginResult {

    private Boolean switchLogin;

    private User user;

    private boolean isNewUser = Boolean.FALSE;

    private Integer checkGender;

    private Integer firstFill;

    private String token;

    private String deviceCert;

    private Integer id;

    private Integer userId;

    private String nickname;

    private String mobile;

    private Integer gender;

    private Integer age;

    private String country;

    private String province;

    private String city;

    private String headPortraitsUrl;

    private Long memberExp;

    private Long virtualMemberExp;

    private String imId;

    private String imPsw;

    private Integer type;

    private boolean isCancel;

    private Integer memberLevel;
    //会员头像框
    private String memberHeadPortrail;

    private String memberEmblem;

    private String userCode;//用户编号

    private String nobleBackgroundUrl;//资料背景图

    private Integer platformAuth;//认证状态,0未认证,1认证达人，2官方认证


    /*==================== admin使用 ================================*/
    private String name;

    private String username;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String salt;

    private Integer status;

    private String imPwd;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date createTime;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date updateTime;

    private Integer roleId;

    private String roleName;

    private String adminName;
}
