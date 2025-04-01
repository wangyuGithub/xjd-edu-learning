package com.xjd.edu.user.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xjd.edu.user.entity.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author wangyu
 * @email wangyu@sina.com
 * @date 2025-03-30 13:01:14
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
