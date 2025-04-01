package com.xjd.edu.common.enums;

import cn.hutool.core.collection.CollectionUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PlatformEcoEnum implements TypeEnum<Integer> {

    UNKNOW(0, "未知"),
    /**
     * 开黑陪玩
     */
    PLAY(1, "开黑陪玩"),
    /**
     * 开黑上分
     */
    POINT(2, "开黑上分"),
    /**
     * 微信公众号
     */
    MP(3, "微信公众号"),
    /**
     * IOS
     */
    IOS(4, "IOS"),
    /**
     * ANDROID
     */
    ANDROID(5, "ANDROID"),
    /**
     * 腾讯应用宝
     */
    UMENG_CHANNEL_TENCENT(501, "腾讯应用宝"),
    /**
     * 小米商店
     */
    UMENG_CHANNEL_MIUI(502, "小米商店"),
    /**
     * 百度应用中心
     */
    UMENG_CHANNEL_BAIDU_APP_CENTER(503, "百度应用中心"),
    /**
     * 阿里应用商店
     */
    UMENG_CHANNEL_ALIBABA(504, "阿里应用商店 "),
    /**
     * oppo市场
     */
    UMENG_CHANNEL_OPPO_MARKET(505, "oppo市场"),
    /**
     * vivo市场
     */
    UMENG_CHANNEL_VIVO_MARKET(506, "vivo市场 "),
    /**
     * 华为市场
     */
    UMENG_CHANNEL_HUAWEI(507, "华为市场"),
    /**
     * 360手机助手
     */
    UMENG_CHANNEL_360(508, "360手机助手"),
    /**
     * 魅族市场
     */
    UMENG_CHANNEL_MEIZU(509, "魅族市场"),
    /**
     * 安智市场
     */
    UMENG_CHANNEL_ANDROID_MARKET(510, "安智市场 "),
    /**
     * 三星应用商店
     */
    UMENG_CHANNEL_SAMSUNG(511, "三星应用商店"),
    /**
     * 木蚂蚁
     */
    UMENG_CHANNEL_WOOD_ANTS(512, "木蚂蚁"),
    /**
     * 搜狗手机助手
     */
    UMENG_CHANNEL_SOUGOU(513, "搜狗手机助手"),
    /**
     * 优亿市场
     */
    UMENG_CHANNEL_OPTIMAL_MILLION_MARKET(514, "优亿市场"),
    /**
     * 联想乐商店
     */
    UMENG_CHANNEL_LENOVO(515, "联想乐商店"),
    /**
     * 锤子市场
     */
    UMENG_CHANNEL_HAMMER_MARKET(516, "锤子市场"),
    /**
     * 应用汇
     */
    UMENG_CHANNEL_APP_CHINA(517, "应用汇"),
    /**
     * 安卓园
     */
    UMENG_CHANNEL_ANDROID_PARK(518, "安卓园"),
    /**
     * 聚丰开放平台
     */
    UMENG_CHANNEL_JUFENG_OPEN_PLATFORM(519, "聚丰开放平台"),
    /**
     * 冒泡开发者
     */
    UMENG_CHANNEL_BUBBLE_DEVELOPER(520, "冒泡开发者"),
    /**
     * web官网落地页
     */
    UMENG_CHANNEL_WEB_LANDING_PAGE(521, "web官网落地页"),
    /**
     * oppo推广专包
     */
    UMENG_CHANNEL_OPPO_PROMOTION(522, "oppo推广专包"),
    /**
     * vivo推广专包
     */
    UMENG_CHANNEL_VIVO_PROMOTION(523, "vivo推广专包"),
    /**
     * 百度文库专包
     */
    UMENG_CHANNEL_BAIDU_WENKU(524, "百度文库专包"),
    /**
     * 短信CDK王者荣耀
     */
    UMENG_CHANNEL_SMS_CDK_WZRY(525, "短信CDK王者荣耀 "),
    /**
     * 短信CDK刺激战场
     */
    UMENG_CHANNEL_CDK_CJZC(526, "短信CDK刺激战场"),
    QIANYI(530, "千易"),
    NEW_ANDROID_PLATFORM1(531, "悠盟"),
    NEW_ANDROID_PLATFORM2(532, "聚财"),
    NEW_ANDROID_PLATFORM3(533, "泉盟"),
    NEW_ANDROID_PLATFORM4(534, "聚财1"),
    NEW_ANDROID_PLATFORM5(535, "51平台"),
    NEW_ANDROID_PLATFORM6(536, "51平台-1"),
    NEW_ANDROID_PLATFORM7(537, "千易-1"),
    NEW_ANDROID_PLATFORM8(538, "优趣"),
    NEW_ANDROID_PLATFORM9(539, "千易02"),
    NEW_ANDROID_PLATFORM10(540, "悠盟01"),
    NEW_ANDROID_PLATFORM11(541, "新android渠道11"),
    NEW_ANDROID_PLATFORM12(542, "新android渠道12"),
    NEW_ANDROID_PLATFORM13(543, "新android渠道13"),
    NEW_ANDROID_PLATFORM14(544, "新android渠道14"),
    NEW_ANDROID_PLATFORM15(545, "新android渠道15"),
    NEW_ANDROID_PLATFORM16(546, "新android渠道16"),
    NEW_ANDROID_PLATFORM17(547, "新android渠道17"),
    NEW_ANDROID_PLATFORM18(548, "新android渠道18"),
    NEW_ANDROID_PLATFORM19(549, "新android渠道19"),
    NEW_ANDROID_PLATFORM20(550, "新android渠道20"),
    NEW_ANDROID_PLATFORM21(551, "新android渠道21"),
    NEW_ANDROID_PLATFORM22(552, "新android渠道22"),
    NEW_ANDROID_PLATFORM23(553, "新android渠道23"),
    NEW_ANDROID_PLATFORM24(554, "新android渠道24"),
    NEW_ANDROID_PLATFORM25(555, "新android渠道25"),
    NEW_ANDROID_PLATFORM26(556, "新android渠道26"),
    NEW_ANDROID_PLATFORM27(557, "新android渠道27"),
    NEW_ANDROID_PLATFORM28(558, "新android渠道28"),
    NEW_ANDROID_PLATFORM29(559, "新android渠道29"),
    NEW_ANDROID_PLATFORM30(560, "新android渠道30"),
    NEW_ANDROID_PLATFORM31(561, "新android渠道31"),
    NEW_ANDROID_PLATFORM32(562, "新android渠道32"),
    NEW_ANDROID_PLATFORM33(563, "新android渠道33"),
    NEW_ANDROID_PLATFORM34(564, "新android渠道34"),
    NEW_ANDROID_PLATFORM35(565, "新android渠道35"),
    NEW_ANDROID_PLATFORM36(566, "新android渠道36"),
    NEW_ANDROID_PLATFORM37(567, "新android渠道37"),
    NEW_ANDROID_PLATFORM38(568, "新android渠道38"),
    NEW_ANDROID_PLATFORM39(569, "新android渠道39"),
    NEW_ANDROID_PLATFORM40(570, "新android渠道40"),
    NEW_ANDROID_PLATFORM41(571, "新android渠道41"),
    NEW_ANDROID_PLATFORM42(572, "新android渠道42"),
    NEW_ANDROID_PLATFORM43(573, "新android渠道43"),
    NEW_ANDROID_PLATFORM44(574, "新android渠道44"),
    NEW_ANDROID_PLATFORM45(575, "新android渠道45"),
    NEW_ANDROID_PLATFORM46(576, "新android渠道46"),
    NEW_ANDROID_PLATFORM47(577, "新android渠道47"),
    NEW_ANDROID_PLATFORM48(578, "新android渠道48"),
    NEW_ANDROID_PLATFORM49(579, "新android渠道49"),
    NEW_ANDROID_PLATFORM50(580, "新android渠道50"),
    NEW_ANDROID_PLATFORM61(581, "新android渠道51"),
    NEW_ANDROID_PLATFORM62(582, "新android渠道52"),
    NEW_ANDROID_PLATFORM63(583, "新android渠道53"),
    NEW_ANDROID_PLATFORM64(584, "新android渠道54"),
    NEW_ANDROID_PLATFORM65(585, "新android渠道55"),
    NEW_ANDROID_PLATFORM66(586, "新android渠道56"),
    NEW_ANDROID_PLATFORM67(587, "新android渠道57"),
    NEW_ANDROID_PLATFORM68(588, "新android渠道58"),
    NEW_ANDROID_PLATFORM69(589, "新android渠道59"),
    NEW_ANDROID_PLATFORM70(590, "新android渠道60"),


    /**
     * 分期乐
     */
    FENQILE(6, "分期乐"),
    /**
     * 迅雷-PC
     */
    THUNDER(7, "迅雷-PC"),
    /**
     * 交易猫-APP
     */
    JIAOYIMAO(8, "老交易猫"),
    JIAOYIMAO_CONSOCIATION(800, "新交易猫"),

    MIAOLING_CHATROOM(801, "喵铃APP"),

    /**
     * 腾讯加速器
     */
    TENCENT_SPEED_UP(811, "腾讯加速器"),
    TAOBAO(871, "淘宝充值"),

    /**
     * wifi万能钥匙-APP
     */
    WIFI_MASTER_KEY(9, "wifi万能钥匙-APP"),
    /**
     * 迅雷-公众号
     */
    THUNDER_MP(10, "迅雷-公众号"),
    /**
     * APP(android+ios)
     */
    APP(45, "APP(android+ios)"),
    /**
     * Push推送短信
     */
    PUSH_SMS(46, "Push推送短信"),
    /**
     * csdn
     */
    CSDN(51, "csdn"),
    /**
     * G库-PC
     */
    GKU(52, "G库-PC"),
    /**
     * 领航-PC
     */
    LINGHANG(53, "领航-PC"),
    /**
     * 长沙南澳-PC
     */
    NANAO(54, "长沙南澳-PC"),
    /**
     * 靠谱模拟器-PC
     */
    KPMNQ(55, "靠谱模拟器-PC"),
    /**
     * 91游戏服务网-PC
     */
    SHOW91(56, "91游戏服务网-PC"),
    /**
     * 虚贝-PC
     */
    XUBEI(57, "虚贝-PC"),
    /**
     * 卡卡贷-APP
     */
    KAKADAI(58, "卡卡贷-APP"),
    /**
     * 斧牛加速器-PC
     */
    FUNIU(59, "斧牛加速器-PC"),
    /**
     * 领航2-PC
     */
    LINGHANG2(60, "领航2-PC"),
    /**
     * 交易猫-PC
     */
    JIAOYIMAO2(61, "交易猫-PC"),
    /**
     * 开黑陪玩-SOUKA
     */
    SOUKA_PLAY(62, "开黑陪玩-SOUKA"),


    /**
     * 百度-智能小程序
     */
    BAIDU_SMART_PROGRAM(63, "百度-智能小程序"),
    /**
     * 巨量引擎
     */
    OCEAN_ENGINE(70, "巨量引擎"),
    /**
     * H5(通用渠道-MOBILE)
     */
    DEFAULT_MOBILE(999, "H5(通用渠道-MOBILE)"),
    /**
     * H5(通用渠道-PC)
     */
    DEFAULT_PC(1000, "H5(通用渠道-PC)");

    private Integer type;
    private String msg;


    public static PlatformEcoEnum getEnumByType(Integer type) {
        for (PlatformEcoEnum platformEcoEnum : PlatformEcoEnum.values()) {
            if (platformEcoEnum.getType().equals(type)) {
                return platformEcoEnum;
            }
        }
        throw new IllegalArgumentException("{" + type + "}平台不匹配");
    }


    public static String getMsgByType(Integer type) {
        for (PlatformEcoEnum ecoEnum : PlatformEcoEnum.values()) {
            if (ecoEnum.type.equals(type)) {
                return ecoEnum.msg;
            }
        }
        return null;
    }


    public static Boolean isJiaoYiMaoPlatform(Integer type) {
        List<Integer> ourTypeList = CollectionUtil.newArrayList(JIAOYIMAO_CONSOCIATION.getType(), MIAOLING_CHATROOM.getType());
        if (ourTypeList.contains(type)) {
            return true;
        }
        return false;
    }


    /**
     * 是否是自己的平台(开黑陪玩,开黑上分,IOS,ANDROID)
     *
     * @return
     */
    public static Boolean isOursPlatform(Integer type) {
        List<Integer> ourTypeList = CollectionUtil.newArrayList(PLAY.getType(), POINT.getType(), IOS.getType(), ANDROID.getType(), SOUKA_PLAY.getType(), BAIDU_SMART_PROGRAM.getType());
        if (ourTypeList.contains(type)) {
            return true;
        }
        return false;
    }

    @Override
    public TypeEnum<Integer> parse(Integer type) {
        for (PlatformEcoEnum e : PlatformEcoEnum.values()) {
            if (Objects.equals(e.getType(), type)) {
                return e;
            }
        }
        return null;
    }

}
