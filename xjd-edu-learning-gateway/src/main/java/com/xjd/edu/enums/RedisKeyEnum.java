package com.xjd.edu.enums;


/**
 * redis key 前缀
 */
public enum RedisKeyEnum {

    /**
     * 用户token
     */
    PLAY_TOKEN,

    /**
     * 皮皮App登录用户键（也适用于H5）
     */
    GAME_APP_TOKEN_MAPPING,

    /**
     * 管理员token
     */
    ADMIN_TOKEN,

    /**
     * 资金权限控制
     */
    FUND_RISK_CTL,

}
