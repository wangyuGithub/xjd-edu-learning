package com.xjd.edu.common;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Constant implements Serializable {
    public static final String V1 = "V1";
    public static final String V2 = "V2";
    public static final Byte TRUE = 1;

    public static final Byte FALSE = 0;

    public static final String ENCRYPT_CODE = "fulu-game"; // 接口加密串

    public static final Integer DEF_PID = 0; // 默认的父类ID

    public static final Double DEF_RECEIVING_ORDER_PRICE = 1.0;

    public static final String IOS_EMPTY_IDFA = "00000000-0000-0000-0000-000000000000";

    // 手机验证码缓存时间
    public static final Long VERIFYCODE_CACHE_TIME = 5 * 60L;

    public static final Long TIME_MINUTES_FIFE = 5 * 60L;

    // 手机验证码限定次数和限定时间
    public static final Integer MOBILE_CODE_SEND_TIMES = 5; // todo 方便测试
    public static final Long MOBILE_CACHE_TIME = 30 * 60L;

    public static final String WEIXN_JUMP_URL = "https://t-open.apeiwan.com/pc/weixin.html";

    // TODO APP收到的短信中url点击跳转到app
    public static final String APP_JUMP_URL = "皮皮陪玩 APP";

    // 默认评价分
    public static final BigDecimal DEFAULT_SCORE_AVG = new BigDecimal(4);
    // 默认余额
    public static final BigDecimal DEFAULT_BALANCE = new BigDecimal("0.00");
    // 默认魅力值
    public static final Long DEFAULT_CHARM = 0L;
    //百分比
    public static final BigDecimal PERCENTAGE = BigDecimal.valueOf(100);
    //99.9%
    public static final BigDecimal PERCENTAGE_0_99 = BigDecimal.valueOf(0.999);
    public static final BigDecimal PERCENTAGE_0_1 = BigDecimal.valueOf(0.001);

    public static final String DEFAULT_CITY = "未设置";

    public static final Long DEFAULT_VIRTUAL_BALANCE = 0L;

    public static final String DEFAULT_SPLIT_SEPARATOR = ",";

    // 冒号
    public static final String SEPARATOR_COLON = ":";

    // 分号
    public static final String SEPARATOR_SEMICOLON = ";";

    // 逗号
    public static final String COMMA = ",";


    public static final long APP_EXPIRE_TIME = 30 * 24 * 60 * 60;

    public static final Long TIME_HOUR_FIVE = 5 * 60 * 60L;

    /**
     * 24小时
     */
    public static final Long ONE_DAY = 24 * 60 * 60L;
    public static final Long ONE_YEAR = 365 * 24 * 60 * 60L;
    public static final Long HALF_YEAR = ONE_YEAR / 2;

    public static final Long ONE_MONTH = 30 * 24 * 60 * 60L;
    public static final Long THREE_MONTH = 3 * 30 * 24 * 60 * 60L;

    /**
     * 60秒（毫秒值）
     */
    public static final Long MILLI_SECOND_60 = 60 * 1000L;

    /**
     * 5秒（毫秒值）
     */
    public static final Long MILLI_SECOND_5 = 5 * 1000L;

    /**
     * 1周
     */
    public static final Long ONE_WEEK = 7 * 24 * 60 * 60L;

    /**
     * 2周
     */
    public static final Long TWO_WEEK = 2 * ONE_WEEK;
    public static final Long ONE_MINUTE = 60L;
    public static final Long ONE_HOUR = 3600L;

    /**
     * 提现申请的提醒文案
     */
    public static final String CASH_DRAWS_NEXT_TUESDAY_TIPS = "提现金额将在下周二到达您的支付宝账户，请耐心等待";
    public static final String CASH_DRAWS_NEXT_FRIDAY_TIPS = "提现金额将在下周五到达您的支付宝账户，请耐心等待";

    /**
     * 手机号码长度为11
     */
    public static final Integer MOBILE_NUMBER_LENGTH = 11;

    /**
     * 用户头像最少展示个数
     */
    public static final Integer MIN_USER_HEAD_COUNT = 5;

    /**
     * 用户头像最多展示个数
     */
    public static final Integer MAX_USER_HEAD_COUNT = 10;

    /**
     * 发放新用户优惠券成功
     */
    public static final Integer SEND_COUPOU_SUCCESS = 1;

    /**
     * 陪玩师接单Map
     */
    public static final Map<Integer, Object> serviceUserAcceptOrderMap = new ConcurrentHashMap<>();

    /**
     * 没有陪玩师接单
     */
    public static final String SERVICE_USER_NOT_ACCEPT_ORDER = "0";
    /**
     * 陪玩师接单
     */
    public static final String SERVICE_USER_ACCEPT_ORDER = "1";

    /**
     * 用户订单已付款
     */
    public static final String SERVICE_USER_PAY_ORDER = "2";
    /**
     * 分期乐订单--已对账
     */
    public static final Integer IS_RECON = 1;
    /**
     * 分期乐订单--未对账
     */
    public static final Integer UN_RECON = 0;

    /**
     * 举报信息未处理（默认）
     */
    public static final Integer UN_PROCESSED = 0;
    /**
     * 举报信息已处理
     */
    public static final Integer IS_PROCESSED = 1;

    /**
     * 魅力值转化为可提现金额的比例
     */
    public static final BigDecimal CHARM_TO_MONEY_RATE = new BigDecimal("0.07");

    /**
     * 超级管理员用户名
     */
    public static final String ADMIN_USERNAME = "admin";

    /**
     * 马甲前缀(目前用户订单和提现号)
     */
    public static final String VEST_SUFFIX = "V";

    /**
     * 迅雷首页分类
     */
    public static final Integer[] THUNDER_PLAY_AREA_CATEGORY = {32, 33, 30, 31};
    public static final Integer[] THUNDER_CHAT_AREA_CATEGORY = {39, 35, 36};

    public static final Integer TWO_HOUR_WELFARE = 1;
    public static final Integer ONE_ORDER_WELFARE = 2;
    public static final Integer THREE_ORDER_WELFARE = 3;

    /**
     * 迅雷约玩首页banner
     */
    public static final Integer VEST_USER = 4;

    public static final Integer THUNDER_HOMEPAGE_BANNER = 1;

    /**
     * 迅雷约玩列表页banner
     */
    public static final Integer THUNDER_LISTPAGE_BANNER = 2;

    public static final String JYM_ORDER_PREFIX = "JYM";

    public static final String CHANNEL_ORDER_PREFIX = "CNL";

    /**
     * 迅雷优惠券
     */
    public static final String THUNDER_COUPON_REDEEM_CODE = "xunlei1108lanchen";

    /**
     * 迅雷接口url
     */
    public static final String THUNDER_URL = "https://api-u-ssl.xunlei.com";

    /**
     * 迅雷接口签名秘钥
     */
    public static final String THUNDER_PRIVATE_KEY = "EO$feo@#038*%2efe#%^32fe6E)*3";

    public static final String SHUMEI_PRIVATE_KEY = "MIIBOwIBAAJBAKNJKB0816aD8xIcbG9BhHxZvKewP90SaE6/HIVGH4epKpcobjAkBLblve059qu2g4zxjtO/AswijDyfbh2MdBcCAwEAAQJBAINghzAPFgvaOqaly/EwK+LJaOsa+idrehVx2wa4RwIkpp6kaawVc016GfL4qSbCl/Aa3wWEHtUJkgTo3PSIK1ECIQDYgRTu6+XHAv6w/eYgHt66RJ0y6R+aAh+w47f17IIJ2wIhAMESuyBXOundC8kgNq3IBpCczR1pkEoXNlBZOuMtc8l1AiB4tvgyAwuZ+/yAOQDftfafyvQPV9ZL65U57q46i4Ux8wIhAI1XUggN88IKoTseywiTW0L4lywGAKxMq+VMPVDcEFyVAiAK26n/kQOwMmqv+Y2Kla7ABrTzy+1HMKSJgssrIcnonw==";

    /**
     * 迅雷福利余量邮件提醒阈值
     */
    public static final int THUNDER_WELFARE_WARN_LIMIT = 700;

    public static final String RECORD_ACCESS_LOG_MEUN_NAME = "首页";

    /**
     * 品类标签规则TAG_RULE 前缀
     */
    public static final String CATEGORY_TAG_RULE = "CATEGORY_TAG_RULE_";

    /**
     * t_tag标签规则T_TAG 前缀
     */
    public static final String T_TAG = "T_TAG_";

    /**
     * 品类标签TAG 前缀
     */
    public static final String CATEGORY_TAG = "CATEGORY_TAG_";

    /**
     * 服务类型 前缀
     */
    public static final String TECH_SERVICE_INFO_ = "TECH_SERVICE_INFO_";

    public static final String SECRETARY_IM = "zhouxj";

    public static final int DEF_EVALUATE_SCORE = 5;

    /**
     * 登录token
     */
    public static final String LOGIN_TOKEN = "token";

    public static final String DEVICE_CERT = "device-cert";

    /**
     * 请求消息头：认证Id
     */
    public static final String X_AUTH_ID = "X-Auth-Id";

    /**
     * 调用链日志开关
     */
    public static final String CHAIN_LOGGING_ALLOW_KEY = "_chain_logging_allow";

    /**
     * 请求消息头：请求Host
     */
    public static final String X_REQUEST_HOST = "requestHost";
    /**
     * 用户主页查询最新图片或视频动态条数
     */
    public static final Integer NEWEST_DYNAMIC_PIC_VIDEO_COUNT = 4;
    /**
     * 用户主页查询最新文字动态条数
     */
    public static final Integer NEWEST_DYNAMIC_CONTENT_COUNT = 1;

    /**
     * 编辑距离法命中阈值
     */
    public static final float LEVENSHTEIN_THRESHOLD = 0.60f;

    /**
     * 系统折叠触发条数
     */
    public static final int SYSTEM_FOLD_THRESHOLD = 5;


    /**
     * 默认请求超时时间
     */
    public static final int HTTP_DEFAULT_TIMEOUT = 20000;

    /**
     * 分页上限
     */
    public static final int CP_SCHEDULE_LIMIT = 10000;


    /**
     * 点赞内容
     */
    public static final String LIKES_CONTENT = "点了一个赞";

    public static final String THIRDPARTY_HEAD = "http://game-play.oss-cn-hangzhou.aliyuncs.com/2018/9/28/2a0696764cf141a9b75d0afae7d09570.png";
    public static final String NICK_PRE = "游客";
    public static final String HEAD = "https://game-play.oss-cn-hangzhou.aliyuncs.com/img/pipi_default_head.png";

    /**
     * http contentType
     */
    public static final String FORM_DATA = "multipart/form-data";
    public static final String URL_ENCODE = "application/x-www-form-urlencoded";
    public static final String JSON = "application/json";
    public static final String APP_XML = "application/xml";
    public static final String TEXT_XML = "text/xml";

    /**
     * 支付回调请求url 测试和正式
     */
    public static final String PAY_CALLBACK_T_URL = "https://t-callback.apeiwan.com/api/v1/pay";

    // 默认名片宽度
    public static final Integer TECH_CARD_WIDTH = 750;
    // 默认名片高度
    public static final Integer TECH_CARD_HEIGHT = 1467;
    public static final Integer TECH_AUTH_HEIGHT = 1206;
    public static final String ROOM_DEFAULT_PASSWORD = "123456";
    public static final Integer MAX_DAY_NUM = 36500;

    //
    public static final Integer UNDEFINED_LABELID = 0;
    public static final String UNDEFINED_LABELNAME = "Undefined";
    public static final Integer IS_AT_MIC_INDEX = 1;
    public static final Integer CONSTANT_ZERO = 0;
    public static final Integer CONSTANT_MINUS_ONE = -1;
    public static final Integer CONSTANT_MINUS_TWO = -2;
    public static final Integer CONSTANT_ONE = 1;
    public static final Integer CONSTANT_TWO = 2;
    public static final Integer CONSTANT_THREE = 3;
    public static final Integer CONSTANT_FIVE = 5;
    public static final Integer CONSTANT_FOUR = 4;
    public static final Integer CONSTANT_SIX = 6;
    public static final Integer CONSTANT_WEEK = 7;
    public static final Integer CONSTANT_NINE = 9;
    public static final Integer CONSTANT_TEN = 10;
    public static final Integer CONSTANT_THIRTY = 30;
    public static final Integer CONSTANT_HUNDRED = 100;
    public static final Integer CONSTANT_TWO_HUNDRED = 200;
    public static final Integer CONSTANT_THREE_HUNDRED = 300;
    public static final Integer CONSTANT_99 = 99;
    public static final Integer CONSTANT_THOUSAND = 1000;
    public static final Integer CONSTANT_RANK_NUM = 55;
    public static final Integer CONSTANT_RANK_LIMIT = 50;
    public static final Integer PAGE_LIMIT = 999;
    public static final Integer SYSTEM = 9999;
    public static final String GENERAL_CONTENT_RISK_REJECT_MSG = "包含敏感内容，请修改后重新提交";
    public static final String CONTENT_RISK_REJECT_MSG = "包含敏感内容，请修改后重新提交";
    public static final String CONTENT_RISK_IMG_REJECT_MSG = "图片存在敏感信息";
    public static final String ROOM_NAME_RISK_REJECT_MSG = "房间名称包含敏感内容，请修改后重新提交";
    public static final String ROOM_BROADCAST_RISK_REJECT_MSG = "房间广播包含敏感内容，请修改后重新提交";
    public static final String ROOM_NOTICE_RISK_REJECT_MSG = "房间公告包含敏感内容，请修改后重新提交";
    public static final String ROOM_ICON_RISK_REJECT_MSG = "房间封面包含敏感内容，请修改后重新提交";
    public static final String ROOM_WALLPAPER_RISK_REJECT_MSG = "包含敏感内容，请修改后重新提交";
    public static final String CARD_NAME_RISK_REJECT_MSG = "游戏昵称包含敏感内容，请修改后重新提交";
    public static final String ROOM_SLOGAN_RISK_REJECT_MSG = "房间欢迎语包含敏感内容，请修改后重新提交";
    public static final String CONTENT_RISK_REJECT_ROOM_MSG = "图片中含有敏感内容，请修改后再试";
    public static final String CONTENT_RISK_REJECT_NO_FACE = "系统检测到你上传的不是真人头像，请重新上传";
    public static final String CONTENT_RISK_REVIEW_MSG = "文本中包含敏感词汇，将在审核通过后展示";
    public static final String DEFAULT_NICKNAME_REG = "^游客\\d{7}$";
    //陪玩师当天活跃每隔n个小时再次推送
    public static final Integer PLAYEE_DAY_ACTIVE_DELAY_HOUR = 6;
    public static final Integer PLAYEE_DAY_ACTIVE_DELAY_SECONDS = 6 * 60 * 60;
    //新老板注册时间过期天数
    public static final Integer NEW_USER_REGISTER_EXPIRE_DAY = 30;
    //发现老板每次刷新展示占比
    public static final Double USER_ACTION_1TO2_SCALE = 0.3;
    public static final Double USER_ACTION_4TO6_SCALE = 0.1;
    public static final Double CONSTANT_THOUSAND_POINT = 0.001;
    public static final Long ACTIVE_TIME_MILLI_SECOND_DIFFERENCE = 10 * 60 * 1000L;
    public static final long USER_VERSION_EXPIRE_TIME = TimeUnit.HOURS.toSeconds(24);
    public static final Integer ACTIVE_TIME_MINUTE_DIFFERENCE = 10;
    public static final Integer ES_UPDATE_RETRY_COUNT = 2;
    //请求提交锁有效时间
    public static final Long SUBMIT_LOCK_DURATION = TimeUnit.SECONDS.toMillis(5);
    //幂等互斥时间
    public static final Long IDEMPOTENT_MUTEX_INTERVAL = TimeUnit.MINUTES.toMillis(5);
    //资料编辑过频文案
    public static final String USER_INFO_LOCK_REJECT_DESC = "申请已提交，请勿重复操作";
    //派单提交过频文案
    public static final String ROOM_DISPATCH_LOCK_REJECT_DESC = "派单已发送，请勿重复操作";
    //钻石红包订单号前缀
    public static final Integer DIAMOND_RED_WRAP_ORDER_NO_PREFIX = 11;
    //礼物红包订单号前缀
    public static final Integer GIFT_RED_WRAP_ORDER_NO_PREFIX = 12;
    //红包集合过期时间延长时长/单位秒
    public static final Integer RED_WRAP_ORDER_EXPIRE_TIME_DELAY = 10 * 60;

    //用户评分配置
    public static final String PLAYEE_CONFIG = "PLAYEE_CONFIG";
    public static final String PLAYEE_COMMENT = "PLAYEE_COMMENT";

    //支付配置
    public static final String PAY_CONFIG = "PAY_CONFIG";
    public static final String DEFAULT_ALI_MERCHANT = "DEFAULT_ALI_MERCHANT";
    public static final String DEFAULT_WECHAT_MERCHANT = "DEFAULT_WECHAT_MERCHANT";


    public static final String APP_USER_CONFIG = "APP_USER_CONFIG";
    public static final String IOS_AUDIT_ACCOUNT = "IOS_AUDIT_ACCOUNT";


    public static final String INVISIBLE_NICKNAME = "神秘人";
    public static final String INVISIBLE_HEAD_PIC = "http://game-play.oss-cn-hangzhou.aliyuncs.com/temp/2020/3/5/0e638846828b48c7bd23c401641ae799.jpg";


    public static final String REQUEST_HOST = "requestHost";

    public static final Date MAX_DATE = new Date(1099, Calendar.JANUARY, 1);

    public static final String[] MONEY_MANAGEMENT_ROLES = {"运营负责人", "特殊人员", "财务人员", "负责人"};

    /**
     * 声网rtcToken默认缓存时间
     */
    public static final Long RTC_TOKEN_DEFAULT_EXPIRE = 86400L;

    /**
     * 订单完成之后自动评价的事件
     */
    public static final Integer ORDER_COMPLETE_AUTO_COMMENT = 24 * 60;

    public static final String MUSIC_ORDER_PRE = "MUSIC_ORDER_PRE";

    // 永久字典键（不设过期时间，动态更新，但永不过期），V1版字典同步键，过渡完成后删除
    @Deprecated
    public static final String DICT_PERMANENT_REDIS_KEY = "app:dict:permanent";
    // 字典 dict_code 集合
    public static final String DICT_CODES_REDIS_KEY = "app:dict:codes";
    public static final String DICT_REDIS_KEY_PREFIX = "app:dict:items:";

    /**
     * 七日礼盒通知领取，单次分页条数默认值
     */
    public static final int WEEK_GIFT_PACK_SEND_PUSH_MAX_NUM = 100;

    /**
     * 七日礼盒起始日期
     */
    public static final LocalDate WEEK_GIFT_PACK_START_DATE = LocalDate.of(2022, 5, 1);

    /**
     * 七日礼盒最大退回天数
     */
    public static final int WEEK_GIFT_PACK_MAX_REFUND_DAYS = 60;
    /**
     * PAGE_SIZE
     */
    public static final int PAGE_SIZE = 20;

    /**
     * CP类型
     */
    public static final int CP_TYPE = 1;


    public static final String ALIPAY_IP = "alipayIp";
    public static final String ALIPAY_FORM = "alipayForm";

    /**
     * 定期返场文案
     */
    public static final String SOMETIMES_BACK = "定期返场";

    /**
     * 巡管导出
     */
    public static final String INSPECTOR_EXPORT = "export";

    /**
     * value 抽奖订单前缀
     */
    public static final String ACTIVITY_JOURNAL_LOTTERY_VALUE_PRE = "AJ_LV";
    /**
     * 皮皮豆兑奖记录
     */
    public static final String ACTIVITY_MALL_LOTTERY_VALUE_PRE = "AM_LV";

    /**
     * 字典缓存键
     *
     * @param dictCode
     * @return
     */
    public static final String dictRedisKey(String dictCode) {
        return DICT_REDIS_KEY_PREFIX + dictCode;
    }

    public void init() {
        log.info("constant init");
    }


    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * www主域
     */
    public static final String WWW = "www.";

    /**
     * RMI 远程方法调用
     */
    public static final String LOOKUP_RMI = "rmi:";

    /**
     * LDAP 远程方法调用
     */
    public static final String LOOKUP_LDAP = "ldap:";

    /**
     * LDAPS 远程方法调用
     */
    public static final String LOOKUP_LDAPS = "ldaps:";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 200;

    /**
     * 失败标记
     */
    public static final Integer FAIL = 500;

    /**
     * 登录成功状态
     */
    public static final String LOGIN_SUCCESS_STATUS = "0";

    /**
     * 登录失败状态
     */
    public static final String LOGIN_FAIL_STATUS = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    //public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 验证码有效期（分钟）
     */
    public static final long CAPTCHA_EXPIRATION = 2;

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";
}
