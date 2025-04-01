package com.xjd.edu.common.enums;


import com.xjd.edu.common.component.ApplicationContextRegister;
import com.xjd.edu.common.config.BizConfig;
import org.springframework.util.Assert;

/**
 * redis key 前缀
 */
public enum RedisKeyEnum {

    /**
     * 管理员token
     */
    ADMIN_TOKEN,
    /**
     * 财务后台管理员token
     */
    FINANCE_ADMIN_TOKEN,
    /**
     * 用户token
     */
    PLAY_TOKEN,
    /**
     * 用户token
     */
    PLAY_TOKEN_MAPPER,
    /**
     * 皮皮App登录Token键（也适用于H5）
     */
    GAME_APP_TOKEN,
    /**
     * 皮皮App登录用户键（也适用于H5）
     */
    GAME_APP_TOKEN_MAPPING,
    /**
     * 小程序的sessionKey
     */
    WX_SESSION_KEY,
    /**
     * 微信消息推送
     */
    WX_TEMPLATE_MSG,
    /**
     * 微信推送点击去重
     */
    BITSET_PUSH_MSG_HITS,
    /**
     * 市场订单接单锁
     */
    MARKET_ORDER_RECEIVE_LOCK,
    /**
     * 判断集市订单是否推送过
     */
    MARKET_ORDER_IS_PUSH,
    /**
     * 表单验证token
     */
    GLOBAL_FORM_TOKEN,
    /**
     * 用户在线状态
     */
    USER_ONLINE_KEY,
    /**
     * 时间间隔
     */
    TIME_INTERVAL_KEY,
    /**
     * 是否已经自动排单用户
     */
    AUTO_ASSIGN_ORDER_USER,
    /**
     * 登录验证码1 皮皮
     */
    SMS_VERIFY_CODE,

    /**
     * 登录验证码1  理想玩伴
     */
    SMS_VERIFY_CODE_PLAYMATE,
    /**
     * 换绑手机号验证码 皮皮
     * 更改前
     */
    SMS_VERIFY_CHANGE_CODE_BEFORE,
    /**
     * 换绑手机号验证码 理想玩伴
     * 更改前
     */
    SMS_VERIFY_CHANGE_CODE_BEFORE_PLAYMATE,
    /**
     * 换绑手机号验证码   皮皮
     * 更改后
     */
    SMS_VERIFY_CHANGE_CODE_AFTER,


    /**
     * 换绑手机号验证码   理想玩伴
     * 更改后
     */
    SMS_VERIFY_CHANGE_CODE_AFTER_PLAYMATE,

    /**
     * 登录验证码发送次数1 皮皮
     */
    SMS_VERIFY_CODE_TIMES,

    /**
     * 登录验证码发送次数1  理想玩伴
     */
    SMS_VERIFY_CODE_TIMES_PLAYMATE,
    /**
     * 时间间隔   皮皮
     */
    SMS_VERIFY_CODE_INTERVAL,

    /**
     * 时间间隔 理想玩伴
     */
    SMS_VERIFY_CODE_INTERVAL_PLAYMATE,
    /**
     * 陪玩师IM未读数据
     */
    IM_COMPANY_UNREAD,
    /**
     * 关注用户
     */
    ATTENTION_USERS,
    /**
     * 大神每天登录任务
     */
    PLAYEE_LOGIN_DUTIES,

    PLAYEE_COMMENT_DUTIES,
    /**
     * 关注用户
     */
    ATTENTION_USERS_ZSET,

    /**
     * 打赏礼物引导
     */
    GIFT_REWARD_USERS_SET,
    /**
     * 被关注用户
     */
    ATTENTIONED_USERS,
    /**
     * 被关注用户
     */
    ATTENTIONED_USERS_ZSET,
    /**
     * 被关注用户-新增
     */
    NEW_ATTENTIONED_USERS,
    /**
     * 管理后台授权
     */
    ADMIN_AUTHED,
    /**
     * 需要随机自动问好的用户
     */
    AUTO_SAY_HELLO_USER_LIST,
    /**
     * 用户未读订单
     */
    USER_WAITING_READ_ORDER,
    /**
     * 用户24小时内开启了代聊
     */
    USER_AGENT_IM_OPEN,
    /**
     * 未接单的订单ID
     */
    ORDER_WAITING_SERVICE_ID,

    /**
     * 消息幂等键
     */
    MSG_IDEMPOTENT,
    /**
     * 访问次数
     */
    ACCESS_COUNT,
    /**
     * 足迹次数
     */
    FOOTPRINT_COUNT,
    /**
     * 聊天室虚拟人数
     */
    CHAT_ROOM_VIRTUAL_COUNT,
    /**
     * 迅雷福利(满2小时)
     */
    THUNDER_WELFARE_2_HOURS,
    /**
     * 迅雷福利(满1单)
     */
    THUNDER_WELFARE_1_ORDER,
    /**
     * 迅雷福利(满3单)
     */
    THUNDER_WELFARE_3_ORDER,
    /**
     * 聊天室在线用户set
     */
    CHAT_ROOM_ONLINE_USER,
    /**
     * 在线用户信息
     */
    CHAT_ROOM_ONLINE_USER_INFO,
    /**
     * 聊天室麦位list
     */
    CHAT_ROOM_MIC,
    /**
     * 上麦列表
     */
    CHAT_ROOM_MIC_UP_LIST,
    /**
     * 订单状态
     */
    THUNDER_ORDER_PAY_STATUS,
    /**
     * 房间信息
     */
    CHAT_ROOM_INFO,
    /**
     * 关厅
     */
    CLOSE_ROOM,
    /**
     * 用户最后登录时间刷新间隔
     */
    LAST_LOGIN_TIME_INTERVAL,
    /**
     * 记录用户每天默认增加的抽奖次数
     */
    ADD_ENTER_DAY,
    /**
     * 用户速配标记
     */
    USER_SPEED_DATING_TASK,
    /**
     * 用户一键下单推送锁
     */
    USER_ONECLICK_PUSH_MSG_INTERVAL,
    /**
     * 用户开始找吧标记
     */
    USER_ONECLICK,
    /**
     * 用户单日过快取消一键下单次数
     */
    USER_ONECLICK_QUICK_CANCEL,
    /**
     * 用户单笔订单手动推送次数
     */
    USER_ONECLICK_SELF_PUSH,
    /**
     * 首轮已推送用户set
     */
    FIRST_USER_ONECLICK_PUSH_SET,
    /**
     * 第二轮已推送用户set
     */
    SECOND_USER_ONECLICK_PUSH_SET,
    /**
     * 用户一键下单试音顺序
     */
    USER_ONECLICK_AUDIOS,
    /**
     * 陪玩师抢速配任务标记
     */
    USER_ROB_SPEED_DATING_TASK_FLAG,
    /**
     * 公司开发者中心
     */
    DEV_CENTER_CACHED_ACCESS_TOKEN,
    /**
     * 公司开发者中心
     */
    DEV_CENTER_CACHED_REFRESH_TOKEN,
    /**
     * 用户活跃时间
     */
    USER_ACTIVE_TIME,
    /**
     * 用户活跃ip
     */
    USER_ACTIVE_IP,
    /**
     * 用户活跃时间更新限频
     */
    USER_ACTIVE_TIME_FREQUENCY,
    /**
     * 用户活动标签类型
     */
    USER_ACTIVITY_TYPE_TAG,
    /**
     * 百度
     */
    BAIDU_ACCESS_TOKEN,
    /**
     * 专属链接海报URL
     */
    MY_POSTER_URL,
    /**
     * APP广场标签列表
     */
    APP_SQUARE_TAG_LIST,
    /**
     * USER_STAT_INFO
     */
    USER_STAT_INFO,
    /**
     * ORDERED_USER
     */
    ORDERED_USER,
    /**
     * NEW_PAYED_USER
     */
    NEW_PAYED_USER,
    /**
     * REGISTERED_USER
     */
    REGISTERED_USER,
    //今日用户被访问的用户列表
    TODAY_USER_VISIT_LIST,
    //今日用户被下单的用户列表
    TODAY_USER_ORDER_LIST,
    //今天所有活跃的用户
    TODAY_ACTIVE_USER_LIST,
    //今天所有活跃的用户
    TODAY_UPDATE_ACTIVE_USER_LIST,

    ADMIN_CAPTCHA_TIMES,

    TOP20_PLAYWITHERIDS,
    WEEK_TOP_ROOM_USER_CHARMS,
    WEEK_TOP_ROOM_USER_DIAMONDS,
    WEEK_TOP_USER_CHARMS,
    MONTH_TOP_USER_CHARMS,
    WEEK_TOP_USER_DIAMONDS,
    MONTH_TOP_USER_DIAMONDS,

    USER_JOIN_MOON_ACTIVITY,
    MIDAUTUMN_CHAPTER_TWO,

    //919活动用户订单数
    ACTIVITY_919_ORDER_USER_COUNT,
    ACTIVITY_919_ORDER_USER_ORDERNOS,
    //919活动陪玩师订单数
    ACTIVITY_919_ORDER_PLAYWITHER_COUNT,
    ACTIVITY_919_ORDER_PLAYWITHER_ORDERNOS,

    //双11钻石累计充值数量
    ACTIVITY_1111_DIAMOND_TOTAL_NUM,
    //双十一累计奖励是否已领取
    ACTIVITY_1111_TOTAL_DIAMOND_ISTAKE,

    //用户点赞次数
    ACTIVITY_919_LIKE_TIMES,
    //用户点了那个评论
    ACTIVITY_919_COMMENT_LIKED,
    SENSITIVE,
    //贵族增加经验事务锁
    LOCK_NOBLE_ADD_EX,
    //首页活动用户弹窗配置
    HOME_PAGE_GET_ACTIVITY_USER,
    //预生成的序列
    SEQUENCE_LIST,

    /**
     * 大神榜单
     */
    GOD_LIST,
    /**
     * 大神榜单成就统计每周一次
     */
    GOD_LIST_MEDAL,

    /**
     * 大神被下单(支付) 超过n次
     * 集合
     */
    GOD_ORDER_NUM_SET,

    /**
     * 大神被下单(支付) 记录
     */
    USER_GOD_ORDER_NUM,

    /**
     * 大神正在开黑中
     */
    ORDERIDNG,

    /**
     * 用户今日收到派单im消息总数
     */
    USER_ASSIGN_COUNT,

    /**
     * 用户今日收到抢单im消息总数
     */
    USER_GRAB_COUNT,

    /**
     * 大神任务完成
     */
    PLAYEE_DUTIES,

    /**
     * 开黑组队房间队伍大神id
     */
    FLIGHT_ROOM_PLAYEE,
    /**
     * 队伍清空时间记录
     */
    FLIGHT_ROOM_PLAYEE_TEAM_CLEAN,
    /**
     * 队伍大神开黑提醒点击记录
     */
    FLIGHT_ROOM_PLAYEE_GAME_CLICK,
    /**
     * 太空飞船活动
     */
    //太空飞船2号活动用户相关数据信息
    USER_SPACE_TRAVEL_INFO,
    //到达终点
    SPACE_TRAVEL_END_ID_LIST,
    //第一个到达
    SPACE_TRAVEL_FIRST_END_ID,
    //用户最新消息
    SPACE_TRAVEL_USER_MSG,
    //用户分享
    SPACE_TRAVEL_SHARE,
    //获得礼物的用户
    SPACE_TRAVEL_RECEIVE_GIFT,
    //获取gif定制的用户
    SPACE_TRAVEL_REWARD_GIF_ICON,

    //心语心愿活动每日任务
    HEART_WISH_SHARE,  //分享
    HEART_WISH_CHAT,   //进入聊天室
    HEART_WISH_ORDER,  //下单陪玩

    //2019双十一抽奖用户信息
    ELEVEN_LOTTERY_USER_INFO,

    //后台im push相关
    ONE_SECOND_TAG, //1秒钟过期标记
    ONE_SECOND_IM_NOTICE_COUNT, //1秒钟im通知数
    NOTICE_IM_PUSH_MSG_ID, //消息通知pushMsgId
    NOTICE_IM_PUSH_MSG_TOTAL_COUNT, //消息通知总数
    NOTICE_IM_PUSH_MSG_REAL_COUNT, //消息通知送达数


    ONE_MINUTE_SMS_NOTICE_COUNT,


    //可秒接相关
    IM_REPLY_REMARK,//IM通信标记
    IM_DELAY_REPLY_PUNISH, //未及时回复惩罚


    //新客价相关
    NEW_PRICE_SYSTEM_TURN_ON,//新客价自动开启标记,存在表示不再开启
    NEW_PRICE_WAIT_FOR_RECOVER,//待自动开启的新客价
    WEEK_NEW_PRICE_REBUY_STAT,//当周新客价复购统计
    NEW_PRICE_CLOSE_MUTEX,//新客价互斥锁

    /**
     * 虚拟充值消费趋势统计相关
     */
    //平台统计 key-平台-ios-日期
    PLATFORM_TREND_STAT,
    //平台新用户趋势统计
    PLATFORM_NEW_USER_TREND_STAT,
    //平台复购率统计
    PLATFORM_REPURCHASE_STAT,
    //平台天复购率统计MAP
    PLATFORM_REPURCHASE_STAT_MAP,
    //平台今天业务用户是否已经存在
    PLATFORM_TODAY_BIZ_EXIST,
    //新用户区间复购
    PLATFORM_NEW_USER_RANGE_PAY_STAT,
    // 用户进入公会厅
    USER_ACCESS_GUILD_ROOM,
    // 声网实时在线人数list
    AGORA_ONLINE_USER_NUM_LIST,
    //用户累计接单时长锁
    USER_TOTAL_SERVICE_TIME_LOCK_KEY,
    USER_PRODUCT_TOTAL_SERVICE_TIME_LOCK_KEY,
    //心愿单排行
    GROUP_WISH_RANK,

    /**
     * 年终盛典活动
     */
    // 最强赛区
    STRONGEST_AREA_INFO,
    // 最强赛区-分赛区晋级标记
    SUB_DIVISION_STAT,
    // 最强赛区-分赛区晋级集合
    SUB_DIVISION_PROVED_LIST,
    // 最强赛区-总榜晋级标记
    WHOLE_AREA_TOTAL_STAT,
    //公会Pk赛-第一场晋级房间
    ACT_YEAR_END_PK_WIN_RACE1,
    //公会Pk赛-第二场晋级房间
    ACT_YEAR_END_PK_WIN_RACE2,
    //火力全开buff
    ACT_YEAR_END_PK_BUFF_HLQK,
    //年度MVP
    YEAR_MVP_TOTAL_SEND_TICKET, //所有用户总投票数排行
    YEAR_MVP_DAY_GET_TICKET,    //用户每天获得的票排行
    YEAR_MVP_SEND_CALL_LIST,    //年度mvp送打call喇叭记录
    YEAR_MVP_LOGIN_ACTIVITY_PAGE,  //年度mvp登录进入活动页记录
    YEAR_MVP_RECOMMEND_USER,  //年度mvp人气推荐用户

    // 保证金退还
    GUILD_FUND_BACK,
    // 公会信誉分扣除
    GUILD_CREDIT_LOCK,
    //周星榜
    WEEK_SEND_GIFT_RANK, //贡献榜单
    WEEK_RECEIVE_GIFT_RANK, //魅力榜单

    //福星等你拿日榜
    NEW_YEAR_STAR_SEND_GIFT_RANK, //送福日榜
    NEW_YEAR_STAR_RECEIVE_GIFT_RANK, //福星日榜

    //鼠年大闯关
    NEW_YEAR_SERVICE_USER_COUNT, //服务老板数量

    //渠道推广配置相关
    AD_PLATFORM_DIC_CACHE,//渠道推广配置缓存
    AD_PLATFORM_DIC_VALID_DAY,//设备号注册绑定有效期

    //全量push频率配置（x分钟）
    ALL_USER_NOTICE_PUSH_RATE,

    //全部普通用户push频率配置（x分钟）
    GENERAL_USER_NOTICE_PUSH_RATE,

    // 动态推荐
    RECOMMEND_DYNAMICS,

    // 亲密好友
    INTIMACY_FRIEND_NOTICE,

    // 最新关注用户的动态的头像
    ATTENTION_USER_DYNAMIC_HEADURL,

    //房间推荐-最近流水刷新时间
    ROOM_JOURNAL_AMOUNT_REFRESH_TIME,

    // 通用活动模版
    COMMON_ACTIVITY,

    // 新增优惠券
    NEW_COUPON_RECEIVED,

    //交友厅用户心动值zset
    FRIEND_ROOM_LOVE_VALUE_RANK,
    //交友厅信息hash
    FRIEND_ROOM_INFO,

    GRADE_PIC_URL_LIST,

    ONECLICK_STA_DIS,
    //派单厅去重set
    ASSIGN_ROOM_STA_DIS,
    //陪玩师bi
    PLAYEE_TREND_STA_DIS,
    //派单厅最近试音
    ASSIGN_ROOM_RECENT_AUDIIONS,
    //陪玩榜单
    PEILIAN_RANK,

    //邀新活动
    INVITE_ACTIVITY_STAT,
    INVITE_ACTIVITY_POSTER,
    //房间上麦主持id
    ROOM_PRE_HOST_USER_ID,
    //fm厅主播开播提醒（1天1次）
    FM_ROOM_HOST_ONLINE_NOTICE,
    //延长守护提醒
    FM_ROOM_RENEW_GUARD_NOTICE,
    //同一用户上麦时间间隔（2秒）
    MIC_HOLD_UP_TIME_LIMIT,
    DEVICE_BLOOM_FILTER,
    FLOW_LIST,
    FLOW_EXPOSED_BLOOM_FILTER,
    //扩列信息流相关
    FLOW_EXPOSED_SET_FILTER,
    EXPANSION_LIKE_USER,
    EXPANSION_BE_LIKE_USER,
    EXPANSION_BE_DISLIKE_USER,

    SYNC_AD_PLATFORM_ID,
    SYNC_AD_PLATFORM_ID_STOP,

    //用户进行中和未完成订单缓存
    USER_NEW_ORDER,
    //陪玩分计算的去重前缀key
    PLAYEE_SCORE,
    //陪玩分上限并发
    PLAYEE_SCORE_LIMIT,
    //陪玩分时长计算的去重前缀key
    PLAYEE_HOURE_SCORE,
    //陪玩分复购计算的去重前缀key
    PLAYEE_TIMES_SCORE,
    //陪玩分复购计算的去重前缀key
    PLAYEE_SERVER_SCORE,
    //用户更新时间刷新
    USER_ACITVE_REFRESH,
    //用户活跃时间更新桶
    USER_ACTIVE_TIME_BUCKET,

    //用户留存统计KEY
    PLATFORM_NEW_USER_REMAIN_DAY_STAT,
    PLATFORM_NEW_USER_REMAIN_WEEK_STAT,
    PLATFORM_NEW_USER_REMAIN_MONTH_STAT,

    FREQUENCY_CONTROL,

    //优质新客
    HIGH_QUALITY_BUY,
    //优质新客复购
    HIGH_QUALITY_REBUY,
    //IM未回复
    IM_NOREPLY,
    //未支付订单数
    ORDER_UNPAY_NUM,
    //抢派单数
    ASSIGN_GRAB_NUM,
    //抢单语音无文字
    GRAB_VOICE_NO_TEXT_SET,
    //FAQ
    FAQ_USER_OPERATOR,
    //提现
    DRAW,

    // 七夕节
    VALENTINE_COUPLE,

    //聊天室公屏消息
    CHAT_ROOM_OPEN_MSG,

    //聊天室礼物订单记录
    ROOM_GIFT_RECORD,

    //金豆子活动
    GOLD_GRAIN,
    /**
     * 短信引导消费
     */
    PHONE_CONSUMER_LEAD,

    //公会pk活动礼物钻石消费记录hash key:20200810:userId
    GUILD_PK_DIAMOND,

    //公会pk热度
    GUILD_PK_HOT,

    //我是主持人活动
    HOST_VOTE,
    //陪玩师推送邀约老板push
    PLAYEE_INVITE_BOSS_PUSH,
    //陪玩师发现老板被邀请的用户
    PLAYEE_DISCOVERY_INVITED_USERS,
    //陪玩师发现老板
    PLAYEE_DISCOVERY_BOSS,
    //用户陪玩中
    USER_SERVICING,
    //每日刷新用户ES近几天满足的品类集合
    USER_REFRESH_ES_CATEGORYS_DAY,
    ROOM_ORDER_DISPATCH_LOCK,
    USER_INFO_EDIT_LOCK,
    USER_INFO_AUTH_LOCK,
    USER_VERSION,
    USER_DEVICE_TYPE,
    USER_DEVICE_PLATFORM,
    PLAYMATE_USER_VERSION,
    PLAYMATE_USER_DEVICE_TYPE,

    //红包数据集合
    RED_WRAP_RESULT,
    //房间红包
    RED_WRAP_ROOM,
    //红包最佳
    RED_WRAP_BEST,

    /**
     * 验证码
     */
    IMAGE_VERIFY_CODE,
    /**
     * 品牌活动 - 新人领券
     */
    YIDONG_ACTIVITY,
    YIDONG_ACTIVITY_SUCCESS,

    //聊天室首页推荐
    ROOM_RECOMMEND,
    //聊天室推荐新版本
    ROOM_MIC_RECOMMEND,
    //聊天室首页推荐魅力榜
    CHARM_TOP,
    //聊天室首页推荐主播榜
    HOST_TOP,
    //兑换
    BALANCE_EXCHANGE,


    CONTENT_RISK_STAT,

    //规则抽奖数量
    RULE_LOTTERY_COUNT,
    //规则抽奖随机数hash
    RULE_LOTTERY_RANDOM,

    //职业认证短信
    CERT_VERIFICATION_CODE,

    //职业认定活动lock
    CERT_ACTIVITY_LOCK,

    //职业认定活动老带新
    CERT_INVITE,
    CERT_INVITE_TEN,
    // 发送装扮
    CERT_ADD_LOTTERY,

    //房间麦位魅力值
    ROOM_MIC_CHARM,

    /**
     * 外部商城订单排他锁
     */
    MALL_ORDER_LOCK,

    //房间倒计时
    ROOM_DEADLINE,

    //房间抢帽子
    ROOM_HAT,

    //房间抢帽子
    ROOM_HAT_CONFIG,

    //公会统计信息
    YEAR_END_2020_GUILD,


    //直播房间连麦数
    ROOM_CONNECT_MIC,
    //房间开厅流水统计信息
    ROOM_JOURNAL_INFO,
    //房间开厅流水统计信息
    ROOM_JOURNAL_DATA_INFO,
    //房间开厅流水统计信息  todo 优化新增加的key
    ROOM_TIME_DATA_INFO,
    //派单厅下单用户
    PLAY_ROOM_ORDER_USER,
    //房间通知信息
    ROOM_NOTICE,
    //公会邀请链接
    GUILD_INVITE_LINK,
    //2020年终盛典-狂欢乐园-宝箱tab（用户是否点击过）
    YEAR_END_2020_BOX,
    //年终盛典火力全开礼物
    YEAR_END_2020_HLQK,
    /**
     * 用户注销 皮皮
     */
    USER_CANCEL,
    /**
     * 用户注销 理想玩伴
     */
    USER_CANCEL_PLAYMATE,
    //年终盛典房间榜单
    YEAR_END_2020_ROOM_RANK,
    //年终盛典主播榜单
    YEAR_END_2020_ANCHOR_RANK,

    //年终盛典-陪玩战区榜单
    YEAR_END_2020_PLAYEE_RANK,
    //用户每日活跃获取积分
    YEAR_END_2020_PLAYEE_ACTIVE_USER,
    //公会成员每日活跃获取积分
    YEAR_END_2020_PLAYEE_ACTIVE_GUILD,
    //陪玩师榜单数据镜像
    YEAR_END_2020_PLAYEE_IMAGE,

    //宝箱狂欢时刻标记
    @Deprecated
    LOTTERY_CARNIVAL_TIME,

    LOTTERY_TWINK_TIME,
    //狂欢倒计时时间
    LOTTERY_CARNIVAL_COUNT_DOWN,
    //宝箱狂欢累计抽奖次数
    @Deprecated
    LOTTERY_CARNIVAL_COUNT,
    //宝箱狂欢抽奖详情
    LOTTERY_CARNIVAL_DETAIL,
    //宝箱狂欢幸运榜
    LOTTERY_LUCKY_RANK,
    //宝箱狂欢幸运榜抽奖礼物数
    @Deprecated
    LOTTERY_LUCKY_COUNT,
    // 腾讯加速器活动下载
    TX_ACTIVITY_DOWNLOAD,

    // 百度token(LOL手游战力活动)
    BAIDU_LOL_ACTIVITY_TOKEN,

    //每天IP访问次数统计(LOL手游战力活动)
    LOL_MOBILE_GAME_USER_IP_COUNT,

    //查询总次数统计(LOL手游战力活动)
    LOL_MOBILE_GAME_COUNT,

    //同一用户送钻石礼物时间间隔（1秒）
    GIFT_SEND_TIME_LIMIT,
    //同一用户开宝箱时间间隔(1秒)
    LOTTERY_BOX_TIME_LIMIT,
    //同一用户开礼盒时间间隔(1秒)
    GIFT_BOX_TIME_LIMIT,
    //圣诞节活动组cp lock
    CHRISTMAS_LOCK,
    //圣诞活动亲密榜-日榜
    CHRISTMAS_DAY_RANK,

    //房间榜单
    ROOM_DAY_RANK, //日榜
    ROOM_WEEK_RANK, //周榜
    // 资金权限控制
    FUND_RISK_CTL,
    //房间小时榜
    ROOM_HOUR_RANK,

    USER_BIND_PHONE,

    // 新玩伴红点控制
    NEW_PLAY_MATE,

    // 新的动态次数统计
    PP_ATTENTION_USER_DYNAMIC_COUNT,
    PP_ATTENTION_USER_DYNAMIC_DETAILS,

    BOOST_ORDER_SUBMIT_USER_LOCK,

    ORDER_SUBMIT_USER_LOCK,
    //心愿单排行

    //粉丝团人气周榜
    FAN_WEEK_RANK,
    //心愿单排行
    //2021春节活动每日个人任务
    SPRING_FESTIVAL_2021_TASK,
    //2021春节活动每日团队任务
    SPRING_FESTIVAL_2021_GROUP_TASK,
    //2021春节活动年兽榜单
    SPRING_FESTIVAL_2021_RANK,
    SPRING_FESTIVAL_2021_RANK_ALL,
    //2021春节活动年兽累计伤害值
    SPRING_FESTIVAL_2021_HEART_VALUE,
    //统计打年兽的用户id
    SPRING_FESTIVAL_2021_HIT_BEAST,
    // 房间引流推送
    ROOM_REFERRAL_TRAFFIC_PUSH,

    //陪玩师等级冷却期
    CERT_CD,
    //新陪玩师等级冷却期
    CERT_NEW_CD,
    //当日接单数冷却期
    TODAY_ORDER_CD,
    //当日退款人数冷却期
    TODAY_REFUND_CD,
    //近一月用户CVR指标冷却期
    CVR_CD,
    //新客价复购冷却期
    STAR_JC_CD,

    /**
     * 超过曝光上线用户 set
     */
    EXPOSURE_ORVER_USERS,

    //超豪消费预警数据统计
    RICHER_CONSUMER_WARN,
    //超豪消费预警消息推送
    RICHER_CONSUMER_MSG,
    //超豪充值预警消息推送
    RICHER_CHARGER_MSG,
    // 影响力锁
    EFFECT_RANK_LOCK,
    // 第100名的影响力
    EFFECT_150TH,
    // 影响力前100名列表
    EFFECT_TOP150,

    //首页入口信息
    HOME_ENTER_INFO,

    //房间pk配置
    ROOM_PK_CONFIG,
    //房间PK榜单
    ROOM_PK_RANK,
    //房间pk魅力榜
    ROOM_PK_CHARM,
    //房间pk魅力榜
    ROOM_PK_CONSUME,
    //房间Pk邀请
    ROOM_PK_INVITATION,
    //房间pk惩罚时间
    ROOM_PK_END,
    ROOM_PK_LIMIT,
    ROOM_PK_OVER,
    //五一活动竞速榜
    LABOR_DAY_RANK,
    // 0422活动
    PLAY_FESTIVAL_POOL_0422,
    PLAY_FESTIVAL_REF_ID_0422,
    PLAY_FESTIVAL_0422,
    PLAY_FESTIVAL_LUCKY_0422,
    IM_TOKEN,
    //五一活动
    LABOR_DAY_LOCK_KEY,
    //IM回复标记缓存
    IM_CONTACT_CACHE,

    //皮皮用户绑定的钉钉信息
    PIPI_USER_BIND_DINGTALK_INFO,
    // 内容控制台用户绑定的钉钉信息
    RISK_ADMIN_USER_BIND_DINGTALK_INFO,
    //钉钉用户信息
    DING_TALK_USER_INFO,
    //钉钉access_token
    DING_TALK_ACCESS_TOKEN,
    // 公会权限
    GUILD_DATA_PERMISSION,
    // 增长520活动
    ACTIVITY_520_TASK_KEY,
    ACTIVITY_520_SCORE_KEY,
    ACTIVITY_520_INVITE_KEY,
    // 增值520活动
    HAND_DAY_RANK,
    HAND_RANK,
    HAND_HEADLINES,
    HAND_SEND_BLESSING,
    HAND_DAY_BLESSING,
    HAND_BLESSING,
    ROOM_UPGRADE_GIFT,
    /**
     * 用户默认昵称生成
     */
    USER_NICK_NAME,
    /**
     * 用户兑换开黑券
     */
    USER_DIAMOND_GIFT_TICKET,
    // ===========聊天室联赛begin===============
    /**
     * 房间赛事获胜者
     * type: hash
     * key: ROOM_LEAGUE_WINNER:{type}
     * hash_key: 1-冠军 2-亚军 3-季军
     * hash_value: roomNo
     * type: 1-房间 2-主播
     */
    ROOM_LEAGUE_WINNER,
    /**
     * 房间赛事榜单
     * type: zset
     * key: ROOM_LEAGUE_RANK:{type}:{stage} or ROOM_LEAGUE_RANK:{type}:{stage}:{date:yyyyMMdd}
     * value: roomNo
     * score: 火力值
     * type: 1-房间 2-主播
     * stage: 1-选拔赛 2-循环赛 3-决赛
     */
    ROOM_LEAGUE_RANK,
    /**
     * 房间晋级名单
     * type: set
     * key: ROOM_LEAGUE_PROMOTION:{type}:{stage}
     * value: roomNoList
     */
    ROOM_LEAGUE_PROMOTION,
    /**
     * 房间PK连胜次数
     * type: hash
     * key: ROOM_PK_STREAK_VICTORY_COUNT:{type}
     * hash_key: roomNo
     * hash_value: victory_count
     * type: 1-房间 2-主播
     */
    ROOM_PK_STREAK_VICTORY_COUNT,
    /**
     * 房间PK获胜次数
     * type: hash
     * key: ROOM_PK_VICTORY_COUNT:{type}
     * hash_key: roomNo
     * hash_value: victory_count
     * type: 1-房间 2-主播
     */
    ROOM_PK_VICTORY_COUNT,
    /**
     * 房间PK结果
     * type: hash
     * key: ROOM_PK_RESULT:{type}:{dateStr}
     * hash_key: roomNo
     * hash_value: 0-失败 1-胜利
     * type: 1-房间 2-主播
     */
    ROOM_PK_RESULT,
    /**
     * 房间PK记录
     * type: hash
     * key: ROOM_PK_RECORDS:{type}:{roomNo}
     * hash_key: dateStr
     * hash_value: -1-失败 0-平局 1-胜利
     */
    ROOM_PK_RECORDS,
    /**
     * 幕后神豪排行榜
     * type: zset
     * key: LEAGUE_RICHER_RANK or LEAGUE_RICHER_RANK:{userId}
     * value: userId or roomNo
     * score: 火力值
     * stage: 1-选拔赛 2-循环赛 3-决赛
     */
    LEAGUE_RICHER_RANK,
    /**
     * 应援团排行榜
     * type: zset
     * key: LEAGUE_ENDAN_RANK  or LEAGUE_ENDAN_RANK:{roomNo}
     * value: roomNo
     * score: 火力值
     * stage: 1-选拔赛 2-循环赛 3-决赛
     */
    LEAGUE_ENDAN_RANK,
    /**
     * 房间PK对阵分配
     * type: hash
     * key: ROOM_PK_LIST:{type}:{dateStr}
     * hash_key: roomNo
     * hash_value: 对手roomNo
     * type: 1-房间 2-主播
     * stage: 1-选拔赛 2-循环赛 3-决赛
     */
    ROOM_PK_LIST,
    /**
     * 房间火力值全服广播推送标记
     */
    ROOM_MATCH_SOCKET_FLAG,
    /**
     * 房间火力值推送
     */
    ROOM_HOT_PUSH_GAP,

    // ===========聊天室联赛end===============

    //通用
    ACTIVITY_DRAW_LIST_COMMON,
    ACTIVITY_SCORE_LIST_COMMON,
    ACTIVITY_RECENT_LIST_COMMON,
    ACTIVITY_INCLUDE_LIST_COMMON,
    ACTIVITY_LOCK_COMMON,
    ACTIVITY_COMMON,
    LOCK_ACTIVITY_USER,
    ACTIVITY_PK_RULE,
    LOCK_ACTIVITY,
    LOCK_ACTIVITY_WELFARE,
    LOCK_WELFARE_CENTER_PRODUCT,
    LOCK_WELFARE_CENTER_USER,
    // 直播厅暂停
    LIVE_PAUSE,
    // 首页聊天室开厅红点提示
    ROOM_COLLECT_RED,
    // 首页聊天室开厅红点提示
    LIVE_ROOM_ATTENTION_RED,
    // 直播定时关厅
    LIVE_ROOM_CLOSE,
    //平台榜单
    TOP_USER_WEEK_RANK, //周榜
    TOP_USER_MONTH_RANK, //月榜
    RTC_TOKEN,//声网rtcToken缓存
    RTC_TOKEN_V2,//声网rtcToken缓存
    RTC_RTM_TOKEN,//rtc rtm Token缓存
    RTC_RTM_TOKEN_V2,//rtc rtm Token缓存
    //RTC 房间人数
    //todo 不要直接用这个key 需要用的话 用二级缓存 防止热key
    RTC_ROOM_COUNT,
    RTC_RTM_ZEGO_TOKEN,//即构rtc rtm Token缓存

    // 增长奇异剧本鲨活动
    ACTIVITY_DRAMA_TASK_KEY,
    ACTIVITY_DRAMA_INVITE_KEY,
    ACTIVITY_DRAMA_SCORE_KEY,
    ACTIVITY_DRAMA_DRAW_KEY,

    //用户人气等级失效延迟消息发送
    USER_POPULARITY_DELAY_MSG_SEND,

    //平台沉淀标签
    PRODUCT_IDS_LABEL_SET,
    //主持给用户创建预订单
    ROOM_ORDER_RECORD,

    //关闭技能和商品  商品id
    CLOSE_TECH_AND_PRODUCT_PRODUCTID,

    //财富等级失效延迟消息发送
    USER_WEALTH_DELAY_MSG_SEND,
    //财富等级
    WEALTH_VALUE_ADD_LOCK_KEY,

    //有声陪伴活动榜单key
    ACTIVITY_ACCOMPANY_RANK_KEY,
    ACTIVITY_ACCOMPANY_LOCK_KEY,
    //
    NEW_USER_TAB_GUIDE,

    //婚礼玩法
    ROOM_WEDDING,
    //婚礼玩法-新郎新娘麦位
    ROOM_WEDDING_MIC,
    //婚礼真爱值
    ROOM_WEDDING_LOVE_VALUE,
    ROOM_WEDDING_LAST_LOVE_VALUE,
    ROOM_WEDDING_LOCK,
    //婚礼广播推送
    ROOM_WEDDING_BROADCAST,

    //房间歌曲待唱列表
    ROOM_SONG_LIST,
    //房间歌曲详情
    ROOM_SONG_DETAIL,
    //房间正在播放歌曲
    ROOM_SONG_PLAY,
    //房间正在播放歌曲
    ROOM_SONG_PLAY_DETAIL,

    //2021七夕活动
    QIXI_DECLARATION_LIKE,
    QIXI_2021_SWEET_RANK,
    QIXI_2022_SWEET_RANK,
    QIXI_HAND_SET,
    QIXI_HAND_WEEK_RANK,
    QIXI_INVITE,
    QIXI_INVITE_SRC,
    QIXI_INVITE_USER,
    QIXI_ACCESS,

    // 房间--结婚
    MARRIED_BLESS,
    MARRIED_RANK,
    // 增长福利中心
    ACTIVITY_WELFARE_CENTER_KEY,
    ACTIVITY_USER_SIGN,
    // 幸运扭蛋机提醒
    ACTIVITY_USER_LUCKY_EGG,
    /**
     * 增长-福利中心任务配置
     * type: list
     * key: ACTIVITY_WELFARE_CENTER_TASK_KEY:{type}
     */
    ACTIVITY_WELFARE_CENTER_TASK_KEY,
    //温青男友音活动key
    BOYFRIEND_VOICE_ACTIVITY,

    //皮皮最美女神活动
    //助攻榜
    GODDESS_ACTIVITY_ASSISTS,
    //日榜 GODDESS_ACTIVITY + yyyy-MM-dd
    GODDESS_ACTIVITY,
    //总榜
    GODDESS_ACTIVITY_TOTAL,

    GODDESS_ACTIVITY_PUSH_TOTAL,

    //房间内部更多房间
    ROOM_INNER_LIST,
    //房间列表
    COMMON_ROOM_LIST,
    //直播房间列表
    LIVE_ROOM_LIST,

    //夏日PK活动redis-key zset
    SUMMER_PK_ACTIVITY_RANK,
    //夏日PK活动redis-key 连胜
    SUMMER_PK_ACTIVITY_WINNER,
    //夏日PK活动redis-key 特殊礼物
    SUMMER_PK_ACTIVITY_GET_GIFT,
    //夏日PK活动redis-key 相同两个主播当日PK次数
    SUMMER_PK_ACTIVITY_SAME_USER,
    //抽宝箱
    LOTTERY_ACTIVITY_LOCK,
    //个人厅寻人广播
    PERSONAL_ROOM_SEEK,

    // 用户大额提现
    USER_LARGE_WITH_DRAWAL,

    // 环信token
    IM_EASEMOB_TOKEN,
    //IOS引导弹框一天弹一次
    IOS_GUIDE_KEY,
    // 个人房间冷启动活动 1个月房间人数统计
    ONE_MONTH_INTO_ROOM_NUM,
    CP_RANK_LOCK,
    // 用户累计在线时长，21年年终盛典使用。后续如果没有删除，可以作为它用。作为它用及时修改注释，避免多处重复使用。
    USER_ONLINE_TIME_STAT,

    /**
     * 用户背包
     */
    USER_BACKPACK,

    // wx ticket
    WX_TICKET,
    WX_ACCESS_TOKEN,
    ROOM_SWITCH_FLOW,
    //信息流缓存
    FLASH_CHAT_FLOW_CACHEKEY,
    //C2C房间首页缓存
    FLASH_CHAT_HOME_CACHEKEY,

    // 互动礼物特效队列
    INTERACTION_STICKER,
    USER_INTERACTION_EXPIRATION,

    EFFECT_RANK_DELETE_LOCK_KEY,

    ROOM_SORT_WINDOW_DIAMOND,
    ROOM_SORT_WINDOW_HOT,

    // ----------------- 成为皮皮CEO begin ---------------------
    PIPI_CEO_NAME,
    PIPI_CEO_QUESTION_IDS,
    PIPI_CEO_USER_COUNT,
    PIPI_CEO_SAVE_COUNT,
    PIPI_CEO_SHARE_COUNT,
    // ----------------- 成为皮皮CEO end ---------------------

    // ------------------TVC begin --------------
    TVC_USER_LIKES,
    TVC_COMMENT_LIKES,
    TVC_COMMENT,
    // ------------------TVC end --------------
    YEAR_END_2021_GUILD_TASK,
    YEAR_END_2021_GUILD_DAILY_TASK,
    YEAR_END_2021_GUILD_TOP_TASK,
    YEAR_END_2021_GUILD_PK_TASK,
    YEAR_END_2021_USER_TASK,
    YEAR_END_2021_USER_PK_TASK,
    YEAR_END_2021_RICH_TASK,

    //ktv 正在演唱歌曲
    KTV_SUNG_DETAIL,
    //ktv 演唱列表
    KTV_SUNG_LIST,
    //ktv 缓存歌曲信息
    KTV_SONG_DETAIL,
    //星光卡抽宝箱
    STAR_LIGHT_LOTTERY,


    // ------------------房间玩法 begin --------------
    DRAW_GAME_INFO,// 你画我猜
    SOUND_GAME_INFO,// 传声筒
    RADISH_SQUAT_GAME_INFO,// 萝卜蹲
    SAY_UPSIDE_DOWN_INFO,// 正话反说
    DO_I_HAVE_YOU_INFO,// 我有你没有
    USER_GAME_OPT_LIMIT,// 游戏操作频率限制
    ROOM_HAND_INFO,//房间牵手
    ROOM_HAND_RANK,//房间牵手心动值
    ROOM_WOLF_INFO,//狼人杀信息
    ROOM_WOLF_ROLE,
    ROOM_WOLF_PREPARE,

    // ------------------房间玩法 end --------------
    //声网在线人数
    AGVORA_ROOM_ONLINE_PEOPLE_NUM,
    //声网在线人数
    AGVORA_ROOM_SINGLE_PEOPLE_NUM,
    //提现限制
    USER_DRAW_CHCHARM,

    // 时光机--领取礼物
    TIME_MACHINE_RECEIVE_GIFT_LOCK,
    // 时光机--领取勋章
    TIME_MACHINE_RECEIVE_MEDAL_LOCK,
    // 时光机--领取壁纸
    TIME_MACHINE_RECEIVE_THEME_LOCK,
    // 每天开启时光机的用户
    TIME_MACHINE_OPEN_USER,
    // 开启时光机显示【全新用户】界面的用户
    TIME_MACHINE_NEW_USER,
    // 每个用户查看时光机的次数
    TIME_MACHINE_USER_COUNT,
    // 点击保存壁纸的人数
    TIME_MACHINE_SAVE_THEME_USER,
    // 设置个人房间壁纸的人数
    TIME_MACHINE_SET_THEME_USER,

    //2021圣诞节礼盒活动榜单
    GIFT_BOX_2021_RANK,

    //陪玩订单 订单号
    ORDER_ORDERNO,
    //代练订单 订单号
    BOOST_ORDER_ORDERNO,
    BOOST_ORDER_SERVICE_PAY,
    BOOST_DEPOSIT_PAY,

    // 谁是卧底
    ROOM_UNDERCOVER,
    ROOM_UNDERCOVER_LOCK,
    // 充值用户
    RECHARGE_USERID,

    // 房间背景音乐
    ROOM_BGM_PLAY_TOKEN,
    ROOM_BGM_STATISTIC,

    // 动态配置dictCode
    DYNAMIC_CONFIG_CODE,

    // 渠道上报
    AD_PLATFORM_REPORT,
    //渠道回调控制
    AD_PLATFORM_CALLBACK,


    /**
     * 主持人身份相关
     */
    ROOM_HOST_STATIS,
    ROOM_HOST_NEW_ACTIVE,
    ROOM_HOST_OLD_ACTIVE,
    ROOM_HOST_NEW_PAY,
    ROOM_HOST_OLD_PAY,

    // 签到延迟弹窗
    WELFARE_SIGN_DELAY,
    //2022春节活动榜单
    SPRING_PETS_RANK,
    SPRING_LUCKY_VALUE,
    SPRING_NOTICE_FLAG,
    SPRING_LOCK,
    VALENTINE_2022_COUPLE,

    // 用户隐私设置
    USER_PRIVACY_SETTINGS,

    /**
     * 扩列榜(财富榜&贡献榜)
     * key: EXPAND_RANK:#{dataTypeEnum}:#{timeTypeEnum}:#{date}
     * type: zset
     * value: userId
     */
    EXPAND_RANK,

    /**
     * 派对榜单
     * key: PARTY_RANK:#{roomCategoryId}:#{timeTypeEnum}:#{date}
     * type:zset
     * value: roomNo
     */
    PARTY_RANK,
    /**
     * 周星榜单
     * key: WEEK_STAR_RANK:#{dataTypeEnum}:#{giftId}:#{date}
     * type:zset
     * value: userId
     */
    WEEK_STAR_RANK,
    /**
     * 水晶榜单
     * key: CRYSTAL_RANK:#{dataTypeEnum}:#{giftId}:#{date}
     * type:zset
     * value: userId
     */
    CRYSTAL_RANK,
    /**
     * 电台榜单
     * key: RADIO_STATION_RANK:#{timeTypeEnum}:#{date}
     * type:zset
     * value: roomNo
     */
    RADIO_STATION_RANK,

    /**
     * 房间榜单(财富榜&贡献榜)
     * key: ROOM_RANK:#{dataTypeEnum}:#{timeTypeEnum}:#{roomNo}:#{date}
     * type:zset
     * value: userId
     */
    ROOM_RANK,

    /**
     * 排名升降状态比对
     * key: RANK_HISTORY_STAT:#{platformRankTypeEnum}:#{timeTypeEnum}:#{业务参数}:#{date}
     * type: hash
     * hash_key: userId或roomNo
     * hash_value: 排名值
     */
    RANK_HISTORY_STAT,

    /**
     * 榜单TOP
     * key: RANK_TOP:#{platformRankTypeEnum}:#{timeTypeEnum}:#{date}
     * type: hash
     * hash_key: “refId”,"total"
     * hash_value: 用户id和次数
     */
    RANK_TOP,

    // -------------动态广场begin---------------
    /**
     * 动态主题参与用户数
     * key: DYNAMIC_TOPIC_USER_COUNT:${topicId}
     * type: hyperloglog
     * value: userId
     */
    DYNAMIC_TOPIC_USER_COUNT_HYPER,
    DYNAMIC_VIEW_DETAIL_RECORD,
    DYNAMIC_UPDATE_ID_LIST,
    DYNAMIC_UPDATE_POND,
    DYNAMIC_INFO,
    DYNAMIC_OPERATE_TIME,
    // ------------- 动态广场end ---------------

    /**
     * 用户封禁申诉成功
     */
    USER_PLEAD_SUCCESS,


    /**
     * 房间蒙面玩法相关
     */
    ROOM_MASKED_USER_INFO,
    ROOM_MASKED_CHARM_INFO,
    ROOM_MASKED_INFO,
    ROOM_MASKED_TIME_INFO,

    /**
     * 房间活动相关
     */
    ROOM_ACTIVITY_SUB,
    ROOM_ACTIVITY_PUSH,

    /**
     * 五一活动相关
     */
    ROOM_CHARM_VALUE,


    // 风控房间音频配置
    RISK_ROOM_AUDIO_CONFIG,
    // 绑定提现手机账号
    BIND_WITHDRAW_MOBILE,
    // 绑定提现手机账号 理想玩伴
    BIND_WITHDRAW_MOBILE_PLAYMATE,

    // 公会赛日榜
    SPRING_BEF_RANK_DAILY,

    // 公会赛总榜
    SPRING_BEF_RANK_TOTAL,

    SPRING_,

    SPRING_RANK_GUILD,

    SPRING_RANK_GUILD_DAILY,

    SPRING_BEF_RANK_CACHE,

    // 公会赛pk榜
    SPRING_BEF_RANK_PK,

    // 公会赛日榜
    SPRING_AFTER_RANK_DAILY,

    // 公会赛总榜
    SPRING_AFTER_RANK_TOTAL,

    // 公会赛pk榜
    SPRING_AFTER_RANK_PK,

    // 公会赛快照
    SPRING_AFTER_RANK_CACHE,


    // 明星榜
    SPRING_BEF_RANK_CHARM,

    // 明星榜
    SPRING_AFTER_RANK_CHARM,

    // 明星pk榜
    SPRING_RANK_PK_CHARM,

    // 明星榜快照
    SPRING_RANK_BEF_CHARM_CACHE,

    SPRING_RANK_AFTER_CHARM_CACHE,


    // 神豪榜
    SPRING_RANK_DIAMOND,

    // 神豪榜快照
    SPRING_RANK_DIAMOND_CACHE,

    /**
     * 秋季联赛
     */

    // 公会赛日榜
    AUTUMN_BEF_RANK_DAILY,

    // 公会赛总榜
    AUTUMN_BEF_RANK_TOTAL,

    AUTUMN_,

    AUTUMN_RANK_GUILD,

    AUTUMN_RANK_GUILD_DAILY,

    AUTUMN_BEF_RANK_CACHE,

    // 公会赛pk榜
    AUTUMN_BEF_RANK_PK,

    // 公会赛日榜
    AUTUMN_AFTER_RANK_DAILY,

    // 公会赛总榜
    AUTUMN_AFTER_RANK_TOTAL,

    // 公会赛pk榜
    AUTUMN_AFTER_RANK_PK,

    // 公会赛快照
    AUTUMN_AFTER_RANK_CACHE,


    // 明星榜
    AUTUMN_BEF_RANK_CHARM,

    // 明星榜
    AUTUMN_AFTER_RANK_CHARM,

    // 明星pk榜
    AUTUMN_RANK_PK_CHARM,

    // 明星榜快照
    AUTUMN_RANK_BEF_CHARM_CACHE,

    AUTUMN_RANK_AFTER_CHARM_CACHE,


    // 神豪榜
    AUTUMN_RANK_DIAMOND,

    // 神豪榜快照
    AUTUMN_RANK_DIAMOND_CACHE,

    //语音通话
    VOICE_CALL_ONLINE,
    // ----------- 社交关系 begin ----------
    // 亲密好友在同一个房间麦位上的开始时间
    IN_SAME_ROOM_MIC_FRIEND,
    // 亲密好友当天获得的亲密值
    FRIEND_TODAY_ALREADY_INTIMACY_VALUE,
    // 亲密好友亲密值分布式锁
    FRIEND_INTIMACY_VALUE_LOCK,
    // ----------- 社交关系   end ----------

    //七日礼盒
    //key = 送礼人：接收人， val = t_gift_pack_order id
    WEEK_GIFT_PACK_USER_RECEIVE_MAX_ID,

    /**
     * 七日礼盒领取redis锁
     */
    WEEK_GIFT_PACK_USER_RECEIVE_REDIS_KEY,

    /**
     * 七日礼盒赠送redis锁
     */
    WEEK_GIFT_PACK_USER_SEND_REDIS_KEY,

    ROOM_MALE_COUNT,

    ROOM_LADY_COUNT,
    /**
     * 七日礼盒每日push待发送用户id key
     */
    WEEK_GIFT_PACK_USER_READY_PUSH_REDIS_KEY,

    /**
     * 七日礼盒每日push已推送的用户id key
     */
    WEEK_GIFT_PACK_USER_ALREADY_PUSH_REDIS_KEY,
    /**
     * 七日礼盒退回push已发送用户id key
     */
    WEEK_GIFT_PACK_BACK_USER_PUSH_REDIS_KEY,

    /**
     * 礼物勋章全局弹窗次数控制
     */
    GIFT_MEDAL_USER_POP_COUNT,

    /**
     * 公会扶持周礼物流水 - 不可清理，会导致公会扶持错误
     */
    WEEK_GUILD_PROCESS_ROOM_GIFT_STAT,


    /**
     * 活动用户数据统计
     * key: ACTIVITY_USER_STATISTIC:${activityTypeId}:${userId}
     * activityTypeId 参考UserStatisticsTypeEnum
     */
    ACTIVITY_USER_STATISTIC,
    /**
     * 公会招募擦亮次数
     */
    GUILD_SUPPLY_RECRUIT_REFRESH_RECORD,
    // 推荐公会列表
    GUILD_CENTER__RECOMMEND_GUILDS,
    // 已处理的合约到期公会成员最大ID
    ALREADY_HANDLE_CONTRACT_EXPIRED_MEMBER_MAX_ID,
    // 退出公会
    QUILT_GUILD_LOCK,

    //vivo渠道token缓存配置
    AD_PLATFORM_VIVO_TOKEN,

    /**
     * alipay支付表单信息
     */
    ALIPAY_GLOBAL_FORM,

    /**
     * 理想玩伴增长活动锁
     */
    ACTIVITY_PLAYMATE_LOCK_KEY,

    /**
     * 理想玩伴增长活动任务key
     */
    ACTIVITY_PLAYMATE_JOB_KEY,

    /**
     * 理想玩伴增长活动邀请key
     */
    ACTIVITY_PLAYMATE_INVITE_KEY,


    /**
     * 皮皮控制台标识
     */
    SYSTEM_ADMIN_PIPI,

    /**
     * 内容控制台标识
     */
    SYSTEM_ADMIN_RISK,

    /**
     * 资金控制台标识
     */
    SYSTEM_ADMIN_CAPITAL,

    /**
     * bi控制台标识
     */
    SYSTEM_ADMIN_BI,

    /**
     * 获取华为token
     */
    AD_PLATFORM_HUAWEI_TOKEN_KEY,

    /**
     * 抽奖库存
     */
    ACTIVITY_DRAW_STOCK_PRE,

    //星座奇缘送礼人排行总榜
    CONSTELLATION_SENDER_RANK,
    //星座奇缘送礼人排行日榜
    CONSTELLATION_SENDER_RANK_DAY,
    //星座奇缘收礼人排行总榜
    CONSTELLATION_TARGET_RANK,
    //星座奇缘收礼人排行日榜
    CONSTELLATION_TARGET_RANK_DAY,
    //星座奇缘幂等key
    CONSTELLATION_IDEMPOTENT_KEY,
    //星座奇缘任务分布式锁key
    CONSTELLATION_GIFT_BOX_TASK_LOCK_KEY,
    CONSTELLATION_ROOM_TASK_LOCK_KEY,
    //星座奇缘抽奖分布式锁key
    CONSTELLATION_LOTTERY_LOCK_KEY,
    //用户激活key
    AD_PLATFORM_DEVICE,

    // 更新房间开厅时长的分布式锁
    ROOM_TIME_UPDATE_LOCK,
    // 房间开厅时长的最后更新时间
    ROOM_TIME_LAST_UPDATE_TIME,
    // 公会成长的有效房间/成员/用户
    GUILD_GROWTH_EFFECTIVE,

    /**
     * 周星积分重置待发送Push(周星长线玩法)
     * key: WEEK_SCORE_RESET_PUSH_READY
     * type:set
     * value: userId
     */
    WEEK_SCORE_RESET_PUSH_READY,

    /**
     * 周星积分重置已发送Push通知(周星长线玩法)
     * key: WEEK_SCORE_RESET_PUSH_ALREADY
     * type:set
     * value: userId
     */
    WEEK_SCORE_RESET_PUSH_ALREADY,

    /**
     * 周星玩法积分(周星长线玩法)
     * key: WEEK_STAR_PLAY_SCORE:#{date}
     * type:zset
     * value: userId
     */
    WEEK_STAR_PLAY_SCORE,

    /**
     * 礼物兑换礼物LOCK（周星玩法）
     */
    WEEK_STAR_GIFT_EXCHANGE_LOCK,

    //房间玩法key
    ROOM_GAME_STATUS,


    /**
     * 七夕亲密度处理
     */
    QI_XI_2022_ADD_INTIMACY,
    /**
     * 七夕活动任务
     */
    QI_XI_2022_TASK,

    /**
     * 七夕壁纸奖励
     */
    QI_XI_2022_ROOM_THEMES,

    /**
     * 七夕任务锁
     */
    QI_XI_2022_TASK_LOCK_KEY,


    /**
     * 夏日玩法大赏活动投票LOCK
     */
    SUMMER_PLAY_2022_VOTE_LOCK,

    // ------------- 2022秋季联赛 begin ------------------
    /**
     * 代言礼物榜单
     */
    AUTUMN_LEAGUE_GIFT_RANK,

    /**
     * 代言礼物奖励记录
     */
    AUTUMN_LEAGUE_GIFT_REWARD_RECORD,

    AUTUMN_LEAGUE_POPULARTY_AFTER_VOTE,

    YEAR_END_BEF_POPULARITY,

    YEAR_END_AFTER_POPULARITY,

    YEAR_END_BEF_POPULARITY_cache,

    YEAR_END_AFTER_POPULARITY_cache,
    // ------------- 2022秋季联赛 begin ------------------
    /**
     * 中秋节活动
     */
    MID_AUTUMN_2022_LOAD,

    /**
     * 流量与供给侧- 房间每日统计数据(维度天)
     */
    FLOW_ROOM_STATISTIC_PRE,

    /**
     * 流量与供给侧- 用户每日去重数据(维度天)
     */
    FLOW_ROOM_REPEAT_PRE,

    /**
     * 流量与供给侧- 每日统计房间(维度天)
     */
    FLOW_ROOM_ITEMS_PRE,

    /**
     * 流量与供给侧- 首页弹窗
     */
    FLOW_HOME_ALERT_PRE,
    // 流量与供给侧- 流量同步延迟补偿
    FLOW_ROOM_SYNC_FLAG,

    /**
     * 房间流量包激活时的锁
     */
    ROOM_EXPOSE_ACTIVE_LOCK,
    ROOM_EXPOSE_STAT_PRE,


    /**
     * 礼物墙 正在初始化图鉴
     */
    GIFT_WALL_INIT_ATLAS_SET,

    /**
     * 用户获取新装扮 红点提示
     */
    USER_DECORATIONS_WEAR_TIP,

    /**
     * 置顶动态
     */
    DYNAMIC_SET_TOP,

    /**
     * 礼物墙单个图鉴初始化暂停
     */
    GIFT_WALL_INIT_ATLAS_STOP,

    /**
     * 礼物墙批量图鉴初始化暂停
     */
    GIFT_WALL_ALL_ATLAS_STOP,

    FRIEND_OPERATION_LOCK,

    /**
     * 公会房间统计：进厅人数，付费人数
     */
    GUILD_ROOM_STAT,

    /**
     * 2020国庆活动 用户任务
     */
    NATION_DAY_2022_USER_TASK,

    /**
     * 2020国庆活动 用户多次发送动态
     */
    NATION_DAY_2022_USER_SEND_DYNAMIC,

    /**
     * 2020国庆活动 发送动态 锁
     */
    NATION_DAY_2022_DYNAMIC_LOCK,

    /**
     * 顶象滑块次数
     */
    DING_XIANG_CAPTCHA_NUM,

    /**
     * 获取支付宝人脸识别
     */
    ALI_FACE_AUTH_CARD_NO_LOCK,
    /**
     * 扫脸认证key
     */
    ALI_FACE_AUTH_CACHE,

    /**
     * 支付宝人脸识别
     */
    ALI_FACE_AUTH_LOCK,

    /**
     * 实名信息安全性校验-获取支付宝人脸识别
     */
    SAFE_POLICY_ALI_FACE_AUTH_CARD_NO_LOCK,

    /**
     * 实名信息安全性校验-支付宝人脸识别
     */
    SAFE_POLICY_ALI_FACE_AUTH_LOCK,

    // FAQ 已解决人数
    FAQ_VALID_USER_COUNT_HYPER,
    // FAQ 未解决人数
    FAQ_UNVALID_USER_COUNT_HYPER,

    /**
     * 验证码缓存
     */
    CAPTCHA_CACHE,

    IP_ADDRESS_UPDATE,
    /**
     * 风控验证码token
     */
    RISK_CAPTCHA_TOKEN,
    /**
     * 风控事件token
     */
    RISK_EVENT_TOKEN,

    /**
     * 2022年终盛典活动锁
     */
    YEAR_END_2022_LOCK,

    /**
     * 奖品定时投放任务
     */
    LOTTERY_REGULAR_RELEASE_TASK,

    /**
     * 年终盛典星光池进度
     */
    YEAR_END_2022_STAR_POOL,
    /**
     * 房间动态氛围背景
     */
    ROOM_ATMOSPHERE_BACKGROUND_URL,

    /**
     * 年终盛典邀请函是否弹出
     */
    YEAR_END_2022_INVITATION_POPUP,
    /**
     * 年终盛典邀请函领取锁
     */
    YEAR_END_2022_INVITATION_RECEIVE_LOCK_KEY,

    // 2022年终盛典相关
    // 公会赛日榜
    YEAR_END_BEF_RANK_DAILY,

    // 公会赛总榜
    YEAR_END_BEF_RANK_TOTAL,

    YEAR_END_,

    YEAR_END_RANK_GUILD,

    YEAR_END_RANK_GUILD_DAILY,

    YEAR_END_BEF_RANK_CACHE,

    // 公会赛pk榜
    YEAR_END_BEF_RANK_PK,

    // 公会赛日榜
    YEAR_END_AFTER_RANK_DAILY,

    // 公会赛总榜
    YEAR_END_AFTER_RANK_TOTAL,

    // 公会赛pk榜
    YEAR_END_AFTER_RANK_PK,

    // 公会赛快照
    YEAR_END_AFTER_RANK_CACHE,

    // 明星榜
    YEAR_END_BEF_RANK_CHARM,

    // 明星榜
    YEAR_END_AFTER_RANK_CHARM,

    // 明星pk榜
    YEAR_END_RANK_PK_CHARM,

    // 明星榜快照
    YEAR_END_RANK_BEF_CHARM_CACHE,

    YEAR_END_RANK_AFTER_CHARM_CACHE,


    // 神豪榜
    YEAR_END_RANK_DIAMOND,

    // 神豪榜快照
    YEAR_END_RANK_DIAMOND_CACHE,

    //荣耀实力榜-游戏
    YEAR_END_GAME_RANK,
    //荣耀实力榜-游戏-消息排名
    YEAR_END_GAME_RANK_HOUR,

    /**
     * 风控审核用户昵称信息
     */
    RISK_AUDIT_USER_NAME,

    YEAR_VIDEO_2022_LIKES,
    YEAR_VIDEO_2022_VIEW_USER,

    /**
     * 导出 - 巡管导出
     */
    EXPORT_INSPECTOR_LOCK,

    /**
     * 活动宝箱-抽奖详情-滚动信息条(小广播展示)
     */
    COMMON_LOTTERY_BROADCAST_DETAIL,

    /**
     * 用户反馈重复 30s
     */
    USER_ADVICE_REPEAT_LOCK,

    //记录记录
    ROOM_SCREEN_GIFT_RECORD,

    YEAR_END_STAT_2022_USERS,

    YEAR_END_STAT_2022_KEYWORD,

    YEAR_END_STAT_2022_SHARE_REWARD,
    /**
     * 增值活动任务记录
     */
    VALUE_ACTIVITY_TASK_PREFIX,

    /**
     * 增值活动奖励是否领取
     */
    VALUE_ACTIVITY_REWARD,


    /**
     * 增值活动任务分布式锁
     */
    VALUE_ACTIVITY_TASK_LOCK_KEY,

    /**
     * 圣诞装扮发放分布式锁
     */
    CHRISTMAS_GRANT_REWARD_LOCK_KEY,

    /**
     * 群详情缓存
     */
    GROUP_DETAIL_KEY,

    /**
     * 2023元旦活动-房间在线用户快照
     * key: ROOM_USER_SNAPSHOT:#{roomNo}:#{yyyy-MM-dd HH:mm}
     * type:set
     * value: onlineUserId
     */
    ROOM_USER_SNAPSHOT,

    /**
     * 2023元旦活动-房间麦位用户快照
     * key: ROOM_MIC_USER_SNAPSHOT:#{roomNo}:#{yyyy-MM-dd HH:mm}
     * type:set
     * value: micUserId
     */
    ROOM_MIC_USER_SNAPSHOT,

    /**
     * 2023元旦活动-房间快照
     * key: ROOM_SNAPSHOT
     * type:zset
     * value: roomNo
     */
    ROOM_SNAPSHOT,

    /**
     * 2023元旦活动-烟花卡片快照
     * key: FIREWORKS_CARDS_SNAPSHOT:#{userId}
     * type:string
     * value: roomMicUserIds 麦位用户id 逗号分割
     */
    FIREWORKS_CARD_SNAPSHOT,

    /**
     * 2023元旦活动-烟花卡片PUSH通知
     * key: FIREWORKS_CARD_ALREADY_PUSH
     * type:HyperLogLog
     * value: userId
     */
    FIREWORKS_CARD_ALREADY_PUSH,

    RICHER_CONSUME_EFFECT,

    CHAT_GROUP_UPDATE_OWNER_LOCK_KEY,

    /**
     * 2023春节活动-用户领取红包次数
     * key: SPRING_FESTIVAL_2023_RED_WRAP:${userId}
     * type:String
     * value: num
     */
    SPRING_FESTIVAL_2023_RED_WRAP,

    /**
     * 2023春节活动-话题参与人数
     * key: SPRING_FESTIVAL_2023_TOPIC:${topicId}
     * type:String
     * value: num
     */
    SPRING_FESTIVAL_2023_TOPIC,

    NEW_USER_HOME_SEARCH_KEY,
    CHAT_GROUP_CLICK_FAST,

    //ktv 舞台缓存
    GAME_KTV_SONG_DETAIL,
    //ktv 演唱列表
    GAME_KTV_SONG_LIST,
    // 抢唱
    ROOM_GAME_SNATCH_KTV,
    // 抢唱排名
    ROOM_GAME_SNATCH_RANK,


    VALENTINES_DAY_2023_LOCK_KEY,
    /**
     * 业务逻辑补偿数据
     */
    LOGIC_COMPENSATE_DATA,

    DEVICE_CERT,

    //风控埋点事件key
    RISK_EVENT_KEY,

    ZEGO_SONG_ASYNC_BLOOM_FILTER,

    /**
     * 用户余额锁
     */
    USER_VIRTUAL_BALANCE_LOCK,

    KTV_SONG_SCORE_LOCK,


    KTV_ADD_SONG_LOCK,
    KTV_SNATCH_SONG_LOCK,
    KTV_SNATCH_CUT_SONG_LOCK,


    /**
     * 女神节活动所有人进度key
     */
    GODDESS_DAY_2023_RANK,

    /**
     * 女神节活动女生榜key
     */
    GODDESS_DAY_GIRL_2023,

    /**
     * 座驾相关
     * 座驾房间加成分值
     * 座驾房间排名
     */
    DRIVING_ROOM_HOT_EXP_PRE,
    DRIVING_ROOM_RANK_PRE,
    DRIVING_ROOM_LOCK_PRE,


    /**
     * 搜索MongoDB优化,是否有标签
     */
    BEHAVIOR_LABEL_CONTACT_CACHE,

    /**
     * 用户宝箱 礼盒消费金额 包含代币
     */
    USER_BOX_LOTTERY_DIAMOND,
    //皮皮用户版本号
    PP_USER_VERSION,
    //理想玩伴用户版本号
    LX_USER_VERSION,

    STAR_PARTY_LOCK,

    STAR_PARTY_INDEX,
    /**
     * 控制台发放礼物或装扮频率配置（x分钟）
     */
    ADMIN_PRODUCT_GRANT_RATE,


    /**
     * 闪光值计算
     */
    FLASH_MUSIC_FLASH_VAL,
    /**
     * 闪光节房间榜
     */
    FLASH_MUSIC_KTV,
    /**
     * 闪光节房间日榜
     */
    FLASH_MUSIC_ROOM_DAY,
    /**
     * 闪光节房间榜
     */
    FLASH_MUSIC_ROOM,
    /**
     * 闪光节歌手分值
     */
    FLASH_MUSIC_SINGER,
    /**
     * 闪光节所有用户分值
     */
    FLASH_MUSIC_ALL_USER,
    /**
     * 闪光节用户最高分，val = userIds
     */
    FLASH_MUSIC_KTV_ALL_USER,
    /**
     * 闪光节房间快照
     */
    FLASH_MUSIC_KTV_ROOM_INFO,
    FLASH_MUSIC_KTV_ROOM,

    //闪光节用户加闪光值分布式锁key
    FLASH_MUSIC_ADD_FLASH_VAL_LOCK_KEY,
    //闪光节房间加闪光值分布式锁key
    FLASH_MUSIC_ADD_FLASH_VAL_ROOM_LOCK_KEY,
    ;

    // 缓存时间2分钟
    public static final int two_min_time = 120;

    public static final String SPLIT = "-";
    public static final String SPLIT2 = ":";

    /**
     * Generate Redis Key
     *
     * @param parts
     * @return
     */
    public String generateRedisKey(String... parts) {
        Assert.notEmpty(parts, "参数 parts 不能为空");
        return String.format("%s:%s:%s", this.getEvnPrefix(), this.name(), String.join(SPLIT2, parts));
    }

    public String generateKey(int id) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + id;
    }

    public String generateKey(int parentId, int id) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + parentId + SPLIT + id;
    }

    public String generateKey(String id) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + id;
    }

    public String generateKey(String parentId, String id) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + parentId + SPLIT + id;
    }

    public String generateKey(String parentId, Integer id) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + parentId + SPLIT + id;
    }

    public String generateKey(Integer id, String str) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + id + SPLIT + str;
    }

    public String generateKey() {
        return getEvnPrefix() + SPLIT + this.name();
    }

    public String generateDirKey(int id) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT2 + id;
    }

    public String generateDirKey(String dir) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT2 + dir;
    }

    public String generateDirKey(String... dir) {
        StringBuilder builder = new StringBuilder(getEvnPrefix() + SPLIT + this.name());
        for (String key : dir) {
            builder.append(SPLIT2).append(key);
        }
        return builder.toString();
    }

    public String generateDirKey(Object... dir) {
        StringBuilder builder = new StringBuilder(getEvnPrefix() + SPLIT + this.name());
        for (Object key : dir) {
            builder.append(SPLIT2).append(key.toString());
        }
        return builder.toString();
    }

    public String generateDirKey(String dir, String key) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT2 + dir + SPLIT2 + key;
    }

    public String generateCommonActivityDirKey(String bizKey, String dir) {
        return getEvnPrefix() + SPLIT + bizKey + SPLIT2 + dir;
    }

    /**
     * 获取环境定义的前缀
     *
     * @return
     */
    private String getEvnPrefix() {
        BizConfig config = ApplicationContextRegister.getBean("bizConfigProperties", BizConfig.class);
        return config.getEvn().getPrefix();
    }

    /**
     * 获取渠道统计相关key
     *
     * @return
     */
    public String getPlatformStatKey(String bizKey, int platform, int os, String day) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + bizKey + SPLIT + platform + SPLIT + os + SPLIT + day;
    }

    /**
     * 获取渠道统计相关key
     *
     * @return
     */
    public String getPlatformStatKey(String bizKey, int platform, int os, String day, int statTimeEnum) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + bizKey + SPLIT + platform + SPLIT + os + SPLIT + day + SPLIT + statTimeEnum;
    }

    /**
     * 获取渠道统计相关key
     *
     * @return
     */
    public String getPlatformStatKey(String bizKey, int platform, int os, String begin, String end) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + bizKey + SPLIT + platform + SPLIT + os + SPLIT + begin + SPLIT + end;
    }

    /**
     * 获取渠道统计相关key
     *
     * @return
     */
    public String getPlatformStatKey(String bizKey, int platform, int os, String begin, String end, int statTimeEnum, Integer labelId) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + bizKey + SPLIT + platform + SPLIT + os + SPLIT + begin + SPLIT + end + SPLIT + statTimeEnum + SPLIT + labelId;
    }

    /**
     * 获取邀新活动统计相关key
     *
     * @return
     */
    public String getInviteStatKey(String bizKey, Integer activityId, String begin, String end, int statTimeEnum) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + bizKey + SPLIT + activityId + SPLIT + begin + SPLIT + end + SPLIT + statTimeEnum;
    }

    /**
     * @return
     */
    public String getFaqKey(Integer userId, Integer faqId, String date) {
        return getEvnPrefix() + SPLIT + this.name() + SPLIT + userId + SPLIT + faqId + SPLIT + date;
    }

    /**
     * @return
     */
    public String getUserDrawKey(String cashNo) {
        return getEvnPrefix() + SPLIT + "userDrawRedisKey" + this.name() + SPLIT + cashNo;
    }

    /**
     * @return
     */
    public String getGuildDrawKey(String cashNo) {
        return getEvnPrefix() + SPLIT + "guildDrawRedisKey" + this.name() + SPLIT + cashNo;
    }


    public String getKey(Integer id1, Integer id2, Integer id3) {
        return getEvnPrefix() + SPLIT2 + this.name() + SPLIT2 + id1 + SPLIT2 + id2 + SPLIT2 + id3;
    }

    public String getKey(Integer id1, Integer id2, String id3) {
        return getEvnPrefix() + SPLIT2 + this.name() + SPLIT2 + id1 + SPLIT2 + id2 + SPLIT2 + id3;
    }

    public String getKey(Integer id1, Integer id2, Integer id3, Integer id4) {
        return getEvnPrefix() + SPLIT2 + this.name() + SPLIT2 + id1 + SPLIT2 + id2 + SPLIT2 + id3 + SPLIT2 + id4;
    }

    public String getKey(Integer id1, Integer id2) {
        return getEvnPrefix() + SPLIT2 + this.name() + SPLIT2 + id1 + SPLIT2 + id2 + SPLIT2;
    }

    public String getKey(Integer id1, String id2) {
        return getEvnPrefix() + SPLIT2 + this.name() + SPLIT2 + id1 + SPLIT2 + id2;
    }

    public String getKey(Integer id1) {
        return getEvnPrefix() + SPLIT2 + this.name() + SPLIT2 + id1;
    }


}
