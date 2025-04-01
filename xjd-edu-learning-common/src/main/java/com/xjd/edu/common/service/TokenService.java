package com.xjd.edu.common.service;

import com.xjd.edu.common.entity.User;
import com.xjd.edu.common.enums.HostTypeEnum;

import java.util.Map;

/**
 * 负责操作redis中的token及对应的用户信息
 *
 * @Author libo
 * @date 2020/7/30 5:37 PM
 */
public interface TokenService {

    /**
     * 创建 Token 用户
     *
     * @param user
     * @param type
     * @return
     */
    String create(User user, HostTypeEnum type);

    /**
     * 更新用户（用户关联所有Token信息都会被更新）
     *
     * @param user
     */
    void update(User user);

    /**
     * 根据 Token 查询用户ID
     *
     * @param token
     * @return
     */
    Integer getUserId(String token);

    /**
     * 根据 Token 查询用户信息
     *
     * @param token
     * @return
     */
    Map<String, Object> getUserMap(String token);

    /**
     * 登出时只删除 Token 自身，其映射关系不作处理，后续自然过期或者重新登录时删除
     *
     * @param token
     */
    void delete(String token);

    /**
     * 清空 Token (包含所有终端)
     *
     * @param userId
     */
    void clear(Integer userId);

    /**
     * System(操作)
     *
     * @param token
     */
    void delLoginUser(String token);

}
