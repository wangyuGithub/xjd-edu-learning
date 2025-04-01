package com.xjd.edu.user.entity.user;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wangyu
 * @email wangyu@sina.com
 * @date 2025-03-30 13:01:14
 */
@Data
@TableName("t_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 密码，加密存储
	 */
	private String password;
	/**
	 * 昵称，默认是用户id
	 */
	private String nickName;
	/**
	 * 人物头像
	 */
	private String icon;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
