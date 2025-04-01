package com.xjd.edu.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UserException extends BizException {

    private final ExceptionCode exceptionCode;

    public UserException(ExceptionCode exceptionCode) {
        super();
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMsg();
        this.exceptionCode = exceptionCode;
    }

    public UserException(ExceptionCode exceptionCode, String message) {
        super();
        this.code = exceptionCode.getCode();
        this.message = message;
        this.exceptionCode = exceptionCode;
    }

    @AllArgsConstructor
    @Getter
    public enum ExceptionCode {
        USER_NOT_EXIST_EXCEPTION(20001, "用户不存在"),
        USER_BANNED_EXCEPTION(20000, "用户被封禁"),
        USER_MISMATCH_EXCEPTION(20002, "用户不匹配"),
        IllEGAL_MOBILE_EXCEPTION(20003, "手机号参数为空或不合法"),
        IllEGAL_IMID_EXCEPTION(20004, "imId参数为空或不合法"),
        TECH_AUTH_NOT_EXIST_EXCEPTION(20005, "认证技能记录不存在"),
        MAINPHOTO_NOT_EXIST_EXCEPTION(20006, "用户尚未上传主图"),
        USER_INFO_NULL_EXCEPTION(20007, "未查询到用户信息"),
        USERNAME_DUMPLICATE_EXCEPTION(20008, "用户名重复"),
        NAME_DUMPLICATE_EXCEPTION(20009, "姓名重复"),
        PLAY_WITHER_CHECK_NOT_EXIST_EXCEPTION(20010, "陪玩师考核信息记录不存在"),
        PLAY_WITHER_CHECK_COMPLETED(20011, "陪玩师考核已完成"),
        VERIFICATION_CODE_WRONG(20012, "验证码不正确"),
        USER_BANNED_MSG_EXCEPTION(20013, "用户被封禁"),// 返回封禁信息
        SESSION_KEY_DISABLE_EXCEPTION(21001, "sessionKey过期"),
        WX_PHONE_NOT_EXIST_EXCEPTION(21002, "未获取用户手机号"),
        LOCK_SELF_EXCEPTION(21003, "试图禁用正在登录管理员"),
        LOCK_DENY_EXCEPTION(21004, "已被禁用，无此权限"),
        NO_WECHATECO_EXCEPTION(21005, "没有匹配的微信生态类型"),
        BODY_NO_AUTH(21006, "用户未进行身份验证"),
        BODY_ALREADY_AUTH(21007, "用户已经认证了身份"),
        MOBILE_NOT_MATCH_EXCEPTION(21008, "登录手机号不匹配！"),
        NO_AVAILABLE_OPENID(21009, "无法打款，用户没有有效的openId"),
        NO_PERMISSION(21010, "用户无此访问权限"),
        NO_ROLE(21011, "用户未设置角色信息"),
        NO_ROLE_CLOSE(21012, "账号权限已关闭"),
        ROLE_NAME_EXIST(21013, "角色名已存在"),
        ROUTER_NAME_EXIST(21014, "路由名已存在"),
        USER_CUSTOM_TAG_OVERFLOW(21015, "不能创建太多的自定义标签"),
        USER_MOBILE_IS_EXIST(21016, "您已有手机号不能再绑定"),
        ADMIN_NOT_EXIST_EXCEPTION(21017, "管理员不存在"),
        BODY_AUTH_ING(21018, "用户身份验证信息正在审核中"),
        BODY_AUTH_FAIL(21019, "用户未通过身份验证"),
        DELETED(21020, "用户已被（逻辑）删除"),
        USER_NOT_MATCHING(21021, "用户不匹配"),
        MOBILE_DUMPLICATE_EXCEPTION(21022, "手机号重复"),
        MOBILE_CANNOT_UNBIND_EXCEPTION(21023, "手机号不能解绑"),
        MOBILE_EXIST_CANNOT_UNBIND_EXCEPTION(21024, "该手机号已被其他用户绑定"),
        USER_HAS_MOBILE_EXIST_CANNOT_BIND_EXCEPTION(21025, "您已有手机号不能再绑定"),
        APPOPENID_EXIST_CANNOT_BIND_EXCEPTION(21026, "您已绑定微信号,不允许再绑定"),
        QQOPENID_EXIST_CANNOT_BIND_EXCEPTION(21027, "您已绑定QQ号,不允许再绑定"),
        ONLY_ONE_ACCOUNT_CANNOT_UNBIND_EXCEPTION(21028, "仅有一个账号不能解绑"),
        ILLEGAL_APPOINTMENT_TIME_EXCEPTION(21029, "预约考核时间不合法"),
        STATUS_UPDATE_TIME_EXCEPTION(21030, "状态变更时间不合法"),
        AUTO_LOGIN_EXCEPTION(21031, "一键登入失败，请重试"),
        APPLE_OPENID_EXIST_CANNOT_BIND_EXCEPTION(21032, "您已绑定APPLE,不允许再绑定"),
        USER_FORBID_EXCEPTION(21400, "您的该功能被封禁,在封禁期间内不可使用"),
        USER_ALREADY_DRAWED(21501, "你已经领取过了哦～"),
        USER_DRAW_FAILED(21502, "领取失败，数据保存异常"),
        USER_DRAW_AWARD_RULE_NOT_CONFIG(21503, "领取失败，请联系管理员配置活动规则"),
        USER_DRAW_AWARD_NOT_CONFIG(21504, "领取失败，礼物不存在"),
        USER_DRAW_AWARD_BAD_REQUEST(21505, "领取失败，请求错误"),
        USER_DRAW_AWARD_NOT_NEW(21506, "你已经是老用户啦～"),
        USER_NOBLE_NOT_VALID(21507, "贵族传奇及以上等级才能开启"),
        USER_SETTING_NOT_SUPPORT(21508, "功能正在开发中"),
        USER_ACCOUNT_ALREADY_BIND(21601, "绑定失败，账户已被绑定"),
        USER_ACCOUNT_OPENID_IS_NULL(21602, "绑定失败，输入账号为空"),
        USER_ACCOUNT_OPENID_ALREADY_EXISTS(21603, "绑定失败，已被其它账户绑定"),
        USER_ACCOUNT_ACCOUNT_NOT_EXISTS(21604, "解绑失败，账户不存在"),
        CONTENT_SELF_WORD(21605, "内容含有违禁词,仅自己可见"),
        CONTENT_REJECT_WORD(21606, "内容含有违禁词,拒绝发送"),

        USER_BLACK_AUTHORITY(40001, "对方已将你拉黑"),
        HAS_BLACK_USER_AUTHORITY(40002, "你已将对方拉黑"),
        USER_LEVEL_INVALID(40003, "%s失效无法操作，获得%s值则可恢复"),
        USER_PRIVATE_SETTING_NOT_VALID(40004, "%s%s及以上可开启"),
        USER_VOTE_REPEAT(40005, "已投票，请勿重复投票~"),
        REAL_NAME_AUTH_BLACK_LIST_FORBID(40006, "对方已被平台封禁"),
        BLACK_BALANCE_DEFICIENCY(40007, "发起匹配需要背包中至少有1张开黑券或40钻石"),
        CHAT_FAIL_OUT(40008, "该群聊已解散，无法操作"),
        CHAT_NOT_SEND(40009, "你不在群聊中，无法发送消息"),
        CHAT_FORBID(40010, "该群聊已被封禁，无法发送消息"),
        CHAT_NOT_IN(40011, "你不在群聊中，无法操作"),
        CHAT_NOT_TRY_AGAIN(40012, "有好友取关你了，请重新邀请"),
        SONG_IS_DEL_TO_REFLSH(40013, "此歌曲已被删除，请刷新列表重试"),

        RISK_STRATEGY(80001, "风控策略拦截"),
        ;

        private int code;
        private String msg;
    }


}
