package com.xjd.edu.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xjd.edu.common.entity.User;
import com.xjd.edu.user.entity.user.UserEntity;

/**
 * 
 *
 * @author wangyu
 * @email wangyu@sina.com
 * @date 2025-03-30 13:01:14
 */
public interface UserService extends IService<UserEntity> {
    User findByMobile(String mobile);

    User findById(Integer id);

    //PageUtils queryPage(Map<String, Object> params);
}

