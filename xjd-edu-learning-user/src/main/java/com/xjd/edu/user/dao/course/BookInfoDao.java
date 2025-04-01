package com.xjd.edu.user.dao.course;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xjd.edu.user.entity.course.BookInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 整书资源管理
 * 
 * @author wangyu
 * @email wangyu@sina.com
 * @date 2025-03-30 13:08:32
 */
@Mapper
public interface BookInfoDao extends BaseMapper<BookInfoEntity> {
	
}
