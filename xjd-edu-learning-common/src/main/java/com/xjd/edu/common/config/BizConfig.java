package com.xjd.edu.common.config;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Component("bizConfigProperties")
@Accessors(chain = true)
@ConfigurationProperties(prefix = "config")
@Data
@Slf4j
@Validated
public class BizConfig {

    private Evn evn = new Evn();

    private Oss oss = new Oss();

    private Cloopen cloopen = new Cloopen();

    private Wechat wechat_game = new Wechat();

    private Wechat wechat_game2 = new Wechat();

    private Wechat wechat_poit = new Wechat();
    // 微信公众号
    private Wechat wechat_mp = new Wechat();
    // 玩伴微信公众号
    private Wechat wechat_mp_playMate = new Wechat();

    private Wechat wechat_app = new Wechat();
    // 微信H5支付
    private Wechat wechat_h5 = new Wechat();

    private AppleStore appleStore = new AppleStore();

    private Elasticsearch elasticsearch = new Elasticsearch();

    // 环信账户配置信息
    private Im im = new Im();

    private Queue queue = new Queue();

    private Ordermail ordermail = new Ordermail();

    private ThunderEmail thunderEmail = new ThunderEmail();

    private AlipayPay alipayPay = new AlipayPay();

    //数美配置
    private Shumei shumei = new Shumei();

    //交易猫支付宝配置
    private JiaoyimaoAlipay jiaoyimaoAlipay = new JiaoyimaoAlipay();

    private Fenqile fenqile = new Fenqile();

    private JiaoYiMao jiaoYiMao = new JiaoYiMao();

    private DingTalkConfig dingTalkConfig = new DingTalkConfig();

    private DevCenter devCenter = new DevCenter();

    private BaiduSmartProgram baiduSmartProgram = new BaiduSmartProgram();
    private BaiduOpenPlatform baiduOpenPlatform = new BaiduOpenPlatform();
    private SinaOpenPlatform sinaOpenPlatform = new SinaOpenPlatform();
    private YunDunConfig yunDunConfig = new YunDunConfig();

    private Geetest geetest = new Geetest();

    private PipiAndJym pipiAndJym = new PipiAndJym();

    private RiskApi riskApi = new RiskApi();

    private ThoughtApi thoughtApi = new ThoughtApi();

    private ThoughtApi thoughtApiLarge = new ThoughtApi();

    private LhygApi lhygApiLarge = new LhygApi();
    private LsyApi lsyApi = new LsyApi();

    // 声网信令配置
    private AgoraSignalingConfig agoraSignalingConfig = new AgoraSignalingConfig();

    // 声网RTM配置
    private AgoraRtmConfig agoraRtmConfig = new AgoraRtmConfig();

    // 声网RTM配置
    private ZgoConfig zgoConfig = new ZgoConfig();

    // 声网RTC配置
    private AgoraRtcConfig agoraRtcConfig = new AgoraRtcConfig();

    // Rocketmq配置
    private Rocketmq rocketmq = new Rocketmq();

//    @Deprecated
//    private RedisLockConf redisLockConf = new RedisLockConf();

    //岚晨微信公众号配置
    private WechatProductConf wechat_product_mp = new WechatProductConf();
    //岚晨微信web登录配置
    private WechatProductConf wechat_product_lanc_web = new WechatProductConf();
    //微信商户号1
    private WechatMerNoConf wechat_merno_6151 = new WechatMerNoConf();
    //微信商户号2
    private WechatMerNoConf wechat_merno_1051 = new WechatMerNoConf();
    //岚晨QQ接口配置
    private QqApiConfig qq_api_config_lanc_web = new QqApiConfig();

    //网关配置
    private GatewayConfig gateway_config = new GatewayConfig();
    //支付回调配置
    private PayCallbackConfig pay_callback_config = new PayCallbackConfig();
    //默认支付宝配置
    private AlipayConfig defaultAlipayConfig = new AlipayConfig();
    //默认支付宝配置
    private AlipayConfig sandboxAlipayConfig = new AlipayConfig();
    //默认微信支付配置
    private WechatPayConfig defaultWechatPayConfig = new WechatPayConfig();

    //第三方充值配置
    private TposRecharge tposRecharge = new TposRecharge();

    //websocket配置
    private Ws ws = new Ws();

    @Data
    public static class PipiAndJym {
        private String apiKeySecret;
        private String jymGatewayApi;
    }

    @Data
    public static class RiskApi {
        private String gatewayApi;
    }

    @Data
    public static class ThoughtApi {
        private String gatewayApi;
        private String merchantId;
        private String merchantName;
        private String publicKey;
        private String privateKey;
        private String notifyPublicKey;
    }

    @Data
    public static class LhygApi {
        private String baseUrl;
        private String merchantId;
        private String secretKey;
    }

    @Data
    public static class LsyApi extends LhygApi {
        private String person;
        private String personGuild;
    }

    @Data
    public static class Evn {
        private String prefix;
        private String testDiff;
    }

    @Data
    public static class Oss {
        private String endpoint;
        private String accessKeyId;
        private String accessKeySecret;
        private String bucketName;
        private String host;
        private String cdnHost;
    }

    @Data
    public static class Cloopen {
        private String serverIp;
        private String serverPort;
        private String accountSid;
        private String accountToken;
        // 皮皮 appId
        private String appId;
        // 理想玩伴 appId
        private String appIdPlayMate;
    }

    @Data
    public static class Wechat {
        private String appId;
        private String secret;
        private String token;
        private String aesKey;
        private String msgDataFormat;
        private String mchId;
        private String mchKey;
        private String subAppId;
        private String subMchId;
        private String keyPath;
        private String tradeType;
        // 订单支付回调
        private String notifyUrl;
        // 充值支付回调
        private String payVirtualProductNotifyUrl;

    }

    @Data
    public static class Im {
        private String urlPrefix;
        private String appKey;
        private String orgName;
        private String appName;
        private String grantType;
        private String clientId;
        private String clientSecret;
    }

    @Data
    public static class Elasticsearch {
        private String host;
        private int readTimeout;
        private String indexDB;
        private String username;
        private String password;
        private Map<String, String> rollover;
        private Map<String, Integer> cleanup;
        private Boolean msgSaveSync;
        private Boolean msgSaveOldSync;
        private Boolean msgUpdateSync;
        private Boolean msgUpdateOldSync;
    }

    @Data
    public static class Ordermail {
        private String address;
        private String password;
        private String targetAddress;
    }

    /**
     * 迅雷福利余量不足提醒邮件
     */
    @Data
    public static class ThunderEmail {
        private String address;
        private String password;
        private String targetAddress;
    }

    @Data
    public static class Queue {
        private boolean miniappPush;
        private boolean appPush;
        private boolean userScore;
        private boolean formId;
        private boolean accessLog;
        private boolean msgCenter;
    }

    @Data
    public static class AlipayPay {
        private String appId;
        private String appPrivateKey;
        private String alipayPublicKey;
        private String alipayCallBackPublicKey;
        private String payOrderNotifyUrl;
        private String h5payOrderNotifyUrl;
        private String payVirtualProductNotifyUrl;
        private String h5payVirtualProductNotifyUrl;
        private String payGateway;
    }

    @Data
    public static class JiaoyimaoAlipay {
        private String appId;
        private String appPrivateKey;
        private String alipayPublicKey;
        private String alipayAppPublicKey;
        private String payGateway;
        private String notifyUrl;
    }


    @Data
    public static class AlipayConfig {
        private String appId;
        private String appPrivateKey;
        private String alipayPublicKey;
        private String alipayAppPublicKey;
        //开发者应用公钥证书路径
        private String appCertPath;
        //支付宝公钥证书文件路径
        private String alipayPublicCertPath;
        //支付宝CA根证书文件路径
        private String rootCertPath;
        //网关
        private String gatewayConfig;
    }

    @Data
    public static class WechatPayConfig {
        private String appId;
        private String mchId;
        private String mchKey;
        private String keyPath;
    }

    @Data
    public static class AppleStore {
        private String checkPayUrl;
    }

    @Data
    public static class Fenqile {
        private String sellerId;
        private String clientId;
        private String clientSecret;
        private String version;
        private String partnerId;
        private String partnerKey;
        private String orderNoticeUrl;
        private String orderDetailsUrl;
    }

    @Data
    public static class JiaoYiMao {
        private String appKey;
        private String appSecret;
        private String domain;
        private String apiName;
        private String apiVer;
        private String clientId;
        private String clientSecret;
    }

    @Data
    public static class DingTalkConfig {
        private String webHookToken;
        private String lotteryWebHookToken; //app宝箱夺宝预警群
        private String activityWebHookToken; //常用抽奖活动预警群
    }

    @Data
    public static class DevCenter {
        private String authUrl;
        private String getUserInfoUrl;
        private String getBankListUrl;
        private String clientId;
        private String clientSecret;
    }

    @Data
    public static class BaiduSmartProgram {
        private String appKey;
        private String appSecret;
        private String getSessionKeyByCodeUrl;
        private String getAccessTokenUrl;
        private String sendTemplateMessageUrl;
    }

    @Data
    public static class BaiduOpenPlatform {
        private String appId;
        private String dealId;
        private String appKey;
        private String platformPublicKey;
        private String myPublicKey;
        private String myPrivateKey;
        private String myCallbackUrl;
        private String orderQueryUrl;
        private String cancelConsumedUrl;
        private String applyRefundUrl;
    }

    @Data
    public static class SinaOpenPlatform {
        private String appCode;
        private String shortenUrl;

    }


    @Data
    public static class Geetest {
        private String geetestId;
        private String geetestKey;
        private boolean newfailback;

    }

    @Data
    public static class YunDunConfig {
        private String accessKeyId;
        private String accessKeySecret;
        private String regionId;

        public String getDomain() {
            if ("cn-shanghai".equals(regionId)) {
                return "green.cn-shanghai.aliyuncs.com";
            }
            if ("cn-beijing".equals(regionId)) {
                return "green.cn-beijing.aliyuncs.com";
            }
            if ("ap-southeast-1".equals(regionId)) {
                return "green.ap-southeast-1.aliyuncs.com";
            }
            if ("us-west-1".equals(regionId)) {
                return "green.us-west-1.aliyuncs.com";
            }
            return "green.cn-shanghai.aliyuncs.com";
        }
    }

    @Data
    public static class AgoraSignalingConfig {
        private String appId;
        private String customerId;
        private String certificate;
        private String baseUrl;
        private String roomMsgUrl;
        private String getSongsUrl;
        private String getSongUrl;
        private String checkUserImStatusUrl;
        private String rtmCertificate;
    }

    @Data
    public static class ZgoConfig {
        private String appId;
        private String serverSecret;
    }

    @Data
    public static class AgoraRtmConfig {
        private String appId;
        private String certificate;
    }

    @Data
    public static class AgoraRtcConfig {
        private String appId;
        private String certificate;
    }

    @Data
    public static class Rocketmq {
        private Consumer consumer;
        private Topic topic;
        private Tag tag;


        @Data
        public static class Consumer {
            private String group;
            private String evn;
        }

        @Data
        public static class Topic {
            private String orderEvent;
            private String userEvent;
            private String accessLog;
            private String appMsgPush;
            private String formId;
            private String miniAppMsgPush;
            private String msgCenter;
            private String smsMsgPush;
            private String weixinMsgPush;
            private String agoraSignalPush;
            private String exceptionProducerEvent;
            private String exceptionConsumerEvent;
            private String noticeMsgPush;
            private String userNobleEvent;
            private String couponPush;
            private String orderDispatchEvent;
            private String adPlatformEvent;
            private String contentRiskEvent;
            private String tokenEvent;
            private String lotteryEvent;
            private String financeEvent;
            private String drawEvent;
            private String roomDelayMsgEvent;
            private String dmlTableEvent;
            private String roomFlowEvent;
            private String certEvent;
            private String earlyWarningEvent;
            private String dynamicFlow;
            private String effectRankEvent;
            private String activityContentRiskEvent;
            private String msgCenterSave;
            private String msgCenterUpdate;
            private String userBehaviorEvent;
        }

        @Data
        public static class Tag {
            private String orderEventTag;
            private String userEventTag;
            private String accessLogMsgTag;
            private String appMsgPushTag;
            private String formIdGroupTag;
            private String miniAppMsgPushTag;
            private String msgCenterTag;
            private String smsMsgPushTag;
            private String weixinMsgPushTag;
            private String agoraSignalPushTag;
            private String exceptionProducerEventTag;
            private String exceptionConsumerEventTag;
            private String noticeMsgPushTag;
            private String userNobleEventTag;
            private String couponPushTag;
            private String orderDispatchEventTag;
            private String adPlatformEventTag;
            private String contentRiskEvent;
            private String tokenEventTag;
            private String lotteryEventTag;
            private String financeEventTage;
            private String roomDelayMsgEventTag;
            private String drawEventTag;
            private String dmlTableEventTag;
            private String roomFlowEventTag;
            private String certEventTag;
            private String earlyWarningEventTag;
            private String dynamicRiskTag;
            private String dynamicScoreTag;
            private String effectRankEventTag;
            private String activityContentRiskEventTag;
            private String msgCenterSaveTag;
            private String msgCenterUpdateTag;
            private String userBehaviorTag;
        }
    }

//    @Data
//    public static class RedisLockConf {
//        private String defLockPrefix;
//        private int sleepTime;
//    }

    @Data
    public static class WechatProductConf {
        private String appId;
        private String secret;
        private String token;
        private String aesKey;
    }

    @Data
    public static class WechatMerNoConf {
        private String mchId;
        private String mchKey;
        private String keyPath;
        private String notifyUrl;
    }

    @Data
    public static class QqApiConfig {
        private String appId;
        private String appSecret;
        private String loginRedirectUri;
    }

    /**
     * 各个网关配置
     */
    @Data
    public static class GatewayConfig {
        private String alipayGateway; //支付宝网关
    }

    /**
     * 支付回调配置
     */
    @Data
    public static class PayCallbackConfig {
        private String commonNotifyUrl; //公共支付回调
    }

    @Data
    public static class TposRecharge {
        private String secretKey;
        private String aesIV;
        private String callback;
        private String userId;

        public String getUserId() {
            return StringUtils.isBlank(userId) ? "055d6b56-5ce4-4509-a0ff-a210d1e6e694" : userId;
        }

        public String getSecretKey() {
            return StringUtils.isBlank(secretKey) ? "umSnFCLyVf3hSZVz" : secretKey;
        }

        public String getAesIV() {
            return StringUtils.isBlank(aesIV) ? "1111111111111111" : aesIV;
        }

        public String getCallback() {
            return StringUtils.isBlank(callback) ? "http://robot.open.fulu.com/api/OutOrder/UpdateStatus" : callback;
        }
    }

    @Data
    public static class Ws {

        private String host;

        private String port;

        private String path;

        private String restUrl;
    }

    @Data
    public static class Shumei {
        private String appId;
        private String acessKey;
        private String privateKey;
    }

}
