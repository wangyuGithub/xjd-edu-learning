package com.xjd.edu.common.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户表
 *
 * @author wangbin
 * @date 2018-04-20 11:12:12
 */
@Data
public class User implements Serializable {


    private static final long serialVersionUID = 1L;

    //主键id
    @Excel(name = "用户ID", orderNum = "0", width = 15)
    private Integer id;

    //@EditField(unitName = "基本资料", fieldName = "用户编号", fieldType = AdminEditFieldTypeEnum.TEXT)
    private String userCode;//用户编号
    //手机号
    @Excel(name = "手机号", orderNum = "1", width = 15)
    private String mobile;
    //昵称
    @Excel(name = "昵称", orderNum = "2", width = 15)
    //@EditField(unitName = "基本资料", fieldName = "昵称", fieldType = AdminEditFieldTypeEnum.TEXT)
    private String nickname;
    //性别(0不公开,1男,2女)
    @Excel(name = "性别", orderNum = "3", replace = {"不公开_0", "男_1", "女_2", "_null"}, width = 15)
    //EditField(unitName = "基本资料", fieldName = "性别", fieldType = AdminEditFieldTypeEnum.TEXT, replace = {"0_不公开", "1_男", "2_女"})
    private Integer gender;

    @Excel(name = "年龄", orderNum = "4", width = 15)
    private Integer age;
    /**
     * 星座
     */
    private String constellation;

    //@EditField(unitName = "基本资料", fieldName = "生日", fieldType = AdminEditFieldTypeEnum.TEXT)
    private String birth;

    private String realname;

    private String country;

    private String province;

    private String city;
    //头像URL
    private String headPortraitsUrl;

    private String micFrameUrl;
    // 动态头像
    private String dynamicHeadPortraitsUrl;
    //身份证
    private String idcard;
    //1:普通用户
    private Integer type;
    //信息认证(0未认证,1认证中,2审核通过,3冻结)
    private Integer userInfoAuth;
    @JsonIgnore     // HTTP+JSON 通信时无法传输该字段，需要评估其是否被暴露到了前端（客户端、H5等）
    private String password;
    //    @JsonIgnore
    private String salt;

    private Integer sourceId;

    private BigDecimal balance;

    //状态(0封禁,1为解封)
    private Integer status;

    //注册ip
    @Excel(name = "注册IP", exportFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "15", width = 35)
    private String registIp;

    //注册设备号
    @Excel(name = "注册设备号", exportFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "14", width = 35)
    private String registDeviceNo;

    //登录ip
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "登录IP", exportFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "13", width = 35)
    private String loginIp;
    //陪玩师给用户打的综合评分
    private BigDecimal serverScoreAvg;
    //注册时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "注册时间", exportFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "20", width = 35)
    private Date createTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    //最后登录时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "最后登录时间", exportFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "15", width = 20)
    private Date loginTime;

    // 注册来源类型
    private Integer registerType;

    //删除标记(false：未删除；true：已删除）
    private Boolean delFlag;

    private Integer totalHours;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date activeTime;

    private boolean isCancel;
    /**
     * 主页封面
     */
    private String pageImg;

    /**
     * 审核中主页封面
     */
    private String pageImgInAudit;


    public boolean getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(boolean cancel) {
        isCancel = cancel;
    }

    /**
     * 是否是注册
     */
    private boolean isNewUser = Boolean.FALSE;

    //是否可见 int默认值 3:全部可见
    private Integer visible;

    /**
     * app类型
     */
    private Integer appType;
}
