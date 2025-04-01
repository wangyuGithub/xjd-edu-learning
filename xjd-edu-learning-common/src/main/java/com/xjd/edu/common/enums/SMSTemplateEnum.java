package com.xjd.edu.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum SMSTemplateEnum implements TypeEnum<String> {
    /**
     * 短信验证码
     */
//    VERIFICATION_CODE("689658", "短信验证码"),
    VERIFICATION_CODE("1025661", "1187040", "短信验证码"),

    /**
     * 切换手机号验证码（更改i前）
     */
//    CHANGE_PHONE_CODE_BEFORE("689747", "切换手机号验证码"),
    CHANGE_PHONE_CODE_BEFORE("1025738", "1187017", "切换手机号验证码"),

    /**
     * 切换手机号验证码（更改i后）
     */
//    CHANGE_PHONE_CODE_AFTER("689746", "切换手机号验证码"),
    CHANGE_PHONE_CODE_AFTER("1025736", "1187018", "切换手机号验证码"),

    /**
     * 用户下单付款通知
     */
//    ORDER_PAY_REMIND("689729", "用户下单付款通知"),
    ORDER_PAY_REMIND("1025725", "1187039", "用户下单付款通知"),
    /**
     * 陪玩师接单提醒用户
     */
//    ORDER_RECEIVING("689726", "陪玩师接单提醒用户"),
    ORDER_RECEIVING("1025723", "1187029", "陪玩师接单提醒用户"),
    /**
     * 用户取消订单
     */
//    ORDER_USER_CANCEL("689725", "用户取消订单"),
    ORDER_USER_CANCEL("1025719", "1187030", "用户取消订单"),
    /**
     * 技能审核通过
     */
    TECH_PASS("417385", "417385", "技能审核通过"),
    /**
     * 技能审核未通过
     */
    TECH_UNPASS("407872", "407872", "技能审核未通过"),
    /**
     * 用户申请协商
     */
//    ORDER_CONSULT("689722", "用户申请协商"),
    ORDER_CONSULT("1025718", "1187037", "用户申请协商"),
    //这里之前是开黑陪玩里面模板id为348655的消息模板，因为现在全部在容联新申请的皮皮应用并且配置文件全部用皮皮的appid
    //所以只能发送皮皮的短信模板消息，故这里之前的开黑陪玩的短信模板无法使用，新在皮皮申请的一样的消息模板且模板id如下
    /**
     * 消息提醒
     */
    SMS_REMIND("418416", "1189690", "皮皮消息提醒"),

    /**
     * 陪玩师接单提醒
     */
//    ORDER_TO_TAKE("689701", "新订单接单提醒"),
    ORDER_TO_TAKE("1025717", "1187036", "新订单接单提醒"),
    /**
     * 陪玩师接单提醒
     */
//    ORDER_TO_TAKE("689701", "新订单接单提醒"),
    TICKET_ORDER_TO_TAKE("1186898", "1186979", "新订单接单提醒"),
    /**
     * 陪玩师订单退款提醒
     */
//    ORDER_REFUND("689697", "订单退款提醒"),
    ORDER_REFUND("1025716", "1187035", "订单退款提醒"),

    TICKET_ORDER_REFUND("1186899", "1186978", "订单退款提醒"),

    TICKET_ORDER_APPEALING("1186900", "1186977", "订单仲裁提醒"),

    TICKET_ORDER_SERVER_REJECT_REFUND("1186901", "1186976", "订单大神拒绝退款提醒"),

    /**
     * 用户订单取消
     */
//    ORDER_USER_CANCLE("689691", "订单退款提醒"),
    ORDER_USER_CANCLE("1025714", "1187034", "订单退款提醒"),
    /**
     * 个人资料认证通过
     */
    INFO_AUTH_PASS("582917", "1189691", "个人资料认证通过"),

    /**
     * 个人资料认证不通过
     */
    INFO_AUTH_NO_PASS("582920", "582920", "个人资料认证不通过"),

    /**
     * 身份认证通过
     */
    BODY_AUTH_SUCC("582917", "582917", "身份认证通过"),

    /**
     * 身份认证不通过
     */
    BODY_AUTH_FAIL("582920", "1189694", "身份认证不通过"),

    /**
     * 开始考核
     */
    BEGIN_CHECK("441929", "441929", "开始考核"),

    /**
     * 考核通过
     */
//    CHECK_SUCC("689739", "考核通过"),
    CHECK_SUCC("1025731", "1187022", "考核通过"),
    /**
     * 首次考核通过
     */
//    CHECK_FIRST_SUCC("689740", "考核通过"),
    CHECK_FIRST_SUCC("1025732", "1187021", "考核通过"),
    /**
     * 考核通过
     */
//    CHECK_SUCC_CERT("689742", "考核通过"),
//    CHECK_SUCC_CERT("1025734", "考核通过"),
    CHECK_SUCC_CERT("1029304", "1186986", "考核通过"),
    /**
     * 首次考核通过
     */
//    CHECK_FIRST_SUCC_CERT("689741", "考核通过"),
//    CHECK_FIRST_SUCC_CERT("1025733", "考核通过"),
    CHECK_FIRST_SUCC_CERT("1029304", "1186986", "考核通过"),
    /**
     * 考核未通过
     */
    CHECK_FAIL("582893", "582893", "考核拒绝"),

    /**
     * 首次技能审核成功
     */
    TECH_FIRST_AUDIT_SUCC("587422", "587422", "首次技能审核成功"),
    /**
     * 陪玩师考核未完成
     */
    OL_AUDIT_UNFINISH("438443", "438443", "陪玩师考核未完成"),
    /**
     * 信息审核通过
     */
    EDIT_AUDIT_SUCC("582906", "582906", "信息审核通过"),
    /**
     * 信息审核通过(不用考核的)
     */
//    EDIT_AUDIT_SUCC_NOCHECK("689736", "信息审核通过"),
//    EDIT_AUDIT_SUCC_NOCHECK("1025730", "信息审核通过"),
    EDIT_AUDIT_SUCC_NOCHECK("1029319", "1186985", "信息审核通过"),
//    EDIT_AUDIT_SUCC_NOCHECK("1029304", "信息审核通过"),
    /**
     * 信息审核通过(不用考核的)新人
     */
//    EDIT_AUDIT_SUCC_NOCHECK_NEW("689735", "信息审核通过"),
    EDIT_AUDIT_SUCC_NOCHECK_NEW("1029304", "1186986", "信息审核通过"),
    /**
     * 信息修改审核拒绝
     */
    EDIT_AUDIT_FAIL("582911", "582911", "信息修改审核拒绝"),
    /**
     * 信息审核驳回
     */
    EDIT_AUDIT_REFUSED("582901", "582901", "信息审核驳回"),
    /**
     * 未完成禁考
     */
    OL_AUDIT_LIMIT("582907", "582907", "考核禁止"),
    /**
     * 考核失败禁考
     */
    OL_AUDIT_LIMIT_1("584193", "584193", "考核禁止"),
    /**
     * 信息修改审核通过
     */
    AUDIT_EDIT_SUCC("582913", "582913", "信息修改审核通过"),
    /**
     * 禁考解除
     */
    OL_AUDIT_UNLIMIT("582898", "582898", "禁考解除"),

    /**
     * ios用户充值、注册提醒
     */
    IOS_CHARGE_TIP("615300", "615300", "IOS用户充值提醒"),

    /**
     * 太空之旅活动充值风控提醒
     */
    SPACE_TRAVEL_RECHARGE_NOTICE("689731", "689731", "活动风控提醒"),

    /**
     * 贵族即将到期1天提醒
     */
//    NOBLE_NOTICE_1_DAY("689733", "贵族即将到期1天提醒"),
    NOBLE_NOTICE_1_DAY("1025728", "1187025", "贵族即将到期1天提醒"),

    /**
     * 贵族即将到期3天提醒
     */
//    NOBLE_NOTICE_3_DAY("689732", "贵族即将到期3天提醒"),
    NOBLE_NOTICE_3_DAY("1025727", "1187026", "贵族即将到期3天提醒"),

    /**
     * 短信消费引导
     */
//    PHONE_CONSUMER_LEAD("957281", "短信消费引导"),
//    PHONE_CONSUMER_LEAD("1025778", "短信消费引导"),
    PHONE_CONSUMER_LEAD("1027071", "1192099", "短信消费引导"),
    /**
     * 验证码
     */
    YIDONG_ACTIVITY_SUCCESS("640784", "640784", "移动活动领券成功"),
    /**
     * 用户注销
     */
    USER_CANCEL("407861", "1189692", "用户注销验证码"),
    /**
     * 音乐点唱订单 歌手接单
     */
    MUSIC_ORDER_RECEIVE("1027282", "1186987", "歌手接单"),


    GUILD_PASS("1318348", "1186982", "公会审核通过"),
    GUILD_REFUSE("1157029", "1186983", "公会审核拒绝"),
    ENTERPRISE_PASS("1157031", "1186981", "企业认证审核通过"),
    ENTERPRISE_REFUSE("1157027", "1186984", "企业认证审核拒绝"),
    USER_PLEAD_SUCCESS("1162167", "1186980", "用户申诉成功"),

    TROR_MISS_12_TO_U("", "1210839", "发布订单成功,12小时内无人接单-发给用户"),
    TROR_MISS_24_TO_U("", "1210852", "发布订单成功,24小时内无人接单-发给用户"),
    TROR_TAKE_TO_U("", "1216806", "代练师已接单-发给用户"),
    TROR_NOT_UPLOAD_TO_S("", "1216814", "代练师接单后,超过15分钟未上传首图-发给代练师"),
    TROR_UPLOAD_FIRST_TO_U("", "1216826", "代练上传了首图-发给用户"),
    TROR_S_COMPLETE_TRAIN_TO_U("", "1216834", "代练师完成代练-发给用户"),
    TROR_U_COMPLETE_VERIFY_TO_U("", "1216843", "用户验收完成-发给用户"),
    TROR_U_COMPLETE_VERIFY_TO_S("", "1216859", "用户验收完成-发给代练师"),
    TROR_SYS_COMPLETE_VERIFY_TO_S("", "1216871", "用户未在规定时间验收,系统验收完成-发给代练师"),
    TROR_U_CANCLE_NO_TAKE_TO_U("", "1216879", "用户发起取消订单(无人接单)-发给用户"),
    TROR_U_CANCLE_TAKE_TO_S("", "1216888", "用户发起取消订单(已接单)-发给代练师"),
    TROR_U_CANCLE_S_PROGRESS_TO_U("", "1216912", "代练提交进度结算-发给用户"),
    TROR_U_CANCLE_S_SYS_PROGRESS_TO_U("", "1216916", "代练超时未提交进度,系统进度结算-发给用户"),
    TROR_U_CANCLE_U_AGREE_S_TO_S("", "1216921", "用户同意代练的进度结算明细-发给代练师"),
    TROR_U_CANCLE_U_AGREE_SYS_TO_S("", "1216936", "用户同意系统的进度结算明细-发给代练师"),
    TROR_U_CANCLE_SYS_AGREE_TO_U("", "1216956", "用户超时未处理代练的进度结算明细,系统处理结算明细-发给用户"),
    TROR_U_CANCLE_SYS_AGREE_TO_S("", "1216975", "用户超时未处理代练的进度结算明细,系统处理结算明细-发给代练师"),
    TROR_S_CANCLE_TO_U("", "1216981", "代练师发起取消订单-发给用户"),
    TROR_APPEAl("", "1217012", "发起仲裁-发给非发起人"),
    TROR_APPEAl_MESSAGE("", "1217020", "发起仲裁,客服留言-发给用户或发给代练师"),
    TROR_APPEAl_COMPLETE_TO_ALL("", "1217028", "仲裁完成-发给用户"),
    TROR_ABNORMAL_TO_U("", "1217035", "大神反馈异常-发给用户"),
    TROR_ABNORMAL_U_HANDLE_TO_S("", "1217039", "用户处理大神反馈异常-发给代练师"),
    TROR_ABNORMAL_U_NO_HANDLE_TO_S("", "1217050", "大神超时未确认用户处理结果-发给代练师"),
    TROR_ABNORMAL_S_CONFIRM_TO_S("", "1242407", "你已确认异常反馈已解决，订单异常状态解除，计时继续"),
    TROR_ABNORMAL_S_NO_CONFIRM_TO_U("", "1254922", "大神向你反馈了异常未被解决，为保证代练效率，请进入App查看详情并进行处理。"),

    SMS_NOT_ENOUGH_INVOICE("1722074", "", "皮皮公会提现提醒：你提交的公会提现未上传足额发票，为了确保提现及时到账，请尽快上传对应金额的发票。周二12:00前未上传，系统将自动驳回该周期内申请的提现。"),
    ;

    private String type;
    private String playMateType;
    private String msg;

    @Override
    public TypeEnum<String> parse(String type) {
        for (SMSTemplateEnum e : SMSTemplateEnum.values()) {
            if (Objects.equals(e.getType(), type)) {
                return e;
            }
        }
        return null;
    }

    public static Set<String> getPipiTemplateIds() {
        return Arrays.stream(SMSTemplateEnum.values()).map(SMSTemplateEnum::getType).collect(Collectors.toSet());
    }

    public static Set<String> getPlayMateTemplateIds() {
        return Arrays.stream(SMSTemplateEnum.values()).map(SMSTemplateEnum::getPlayMateType).collect(Collectors.toSet());
    }
}
