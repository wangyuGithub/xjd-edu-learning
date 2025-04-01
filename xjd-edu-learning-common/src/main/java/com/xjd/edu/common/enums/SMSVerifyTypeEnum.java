package com.xjd.edu.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 发送验证码枚举
 */
@AllArgsConstructor
@Getter
public enum SMSVerifyTypeEnum {
    LOGIN(1, "登录", RedisKeyEnum.SMS_VERIFY_CODE, RedisKeyEnum.SMS_VERIFY_CODE_PLAYMATE, SMSTemplateEnum.VERIFICATION_CODE),
    CHANGE_BEFORE(2, "换绑手机号前", RedisKeyEnum.SMS_VERIFY_CHANGE_CODE_BEFORE, RedisKeyEnum.SMS_VERIFY_CHANGE_CODE_BEFORE_PLAYMATE, SMSTemplateEnum.CHANGE_PHONE_CODE_BEFORE),
    CHANGE_AFTER(3, "换绑手机号后", RedisKeyEnum.SMS_VERIFY_CHANGE_CODE_AFTER, RedisKeyEnum.SMS_VERIFY_CHANGE_CODE_AFTER_PLAYMATE, SMSTemplateEnum.CHANGE_PHONE_CODE_AFTER),
    YIDONG_ACTIVITY(4, "移动活动", RedisKeyEnum.YIDONG_ACTIVITY, RedisKeyEnum.YIDONG_ACTIVITY, SMSTemplateEnum.VERIFICATION_CODE),
    YIDONG_ACTIVITY_SUCCESS(5, "移动活动领券成功", RedisKeyEnum.YIDONG_ACTIVITY_SUCCESS, RedisKeyEnum.YIDONG_ACTIVITY_SUCCESS, SMSTemplateEnum.VERIFICATION_CODE),
    CERT_VERIFICATION_CODE(6, "职业认证短信登录", RedisKeyEnum.CERT_VERIFICATION_CODE, RedisKeyEnum.CERT_VERIFICATION_CODE, SMSTemplateEnum.VERIFICATION_CODE),
    USER_CANCEL(7, "用户注销", RedisKeyEnum.USER_CANCEL, RedisKeyEnum.USER_CANCEL_PLAYMATE, SMSTemplateEnum.USER_CANCEL),
    USER_PLEAD_SUCCESS(8, "用户申诉成功", RedisKeyEnum.USER_PLEAD_SUCCESS, RedisKeyEnum.USER_PLEAD_SUCCESS, SMSTemplateEnum.USER_PLEAD_SUCCESS),
    BIND_WITHDRAW_MOBILE(9, "绑定提现手机账号", RedisKeyEnum.BIND_WITHDRAW_MOBILE, RedisKeyEnum.BIND_WITHDRAW_MOBILE_PLAYMATE,SMSTemplateEnum.VERIFICATION_CODE),
    SMS_VERIFY_TYPE_ENUM(10, "理想玩伴活动", RedisKeyEnum.BIND_WITHDRAW_MOBILE, RedisKeyEnum.BIND_WITHDRAW_MOBILE_PLAYMATE,SMSTemplateEnum.VERIFICATION_CODE),
    ;
    private Integer key;
    private String value;
    private RedisKeyEnum keyEnum; //皮皮
    private RedisKeyEnum keyEnumPlayMate; // 理想
    private SMSTemplateEnum smsTemplateEnum;
}
