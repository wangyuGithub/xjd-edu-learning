package com.xjd.edu.user.entity.course;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 整书资源管理
 * 
 * @author wangyu
 * @email wangyu@sina.com
 * @date 2025-03-30 13:08:32
 */
@Data
@TableName("t_book_info")
public class BookInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 数据字典：书本类目
	 */
	private String type;
	/**
	 * 图书馆类型books_type
	 */
	private String libType;
	/**
	 * 上架状态（0已下架 1已上架）
	 */
	private String putaway;
	/**
	 * 删除标志（0未删除 1已删除）
	 */
	private String delFlag;
	/**
	 * 适用年级phase_stage
	 */
	private String grade;
	/**
	 * 图书封面
	 */
	private String coverPic;
	/**
	 * 适用学段phase_stage
	 */
	private String phase;
	/**
	 * 书名
	 */
	private String name;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 出版社
	 */
	private String press;
	/**
	 * 出版时间
	 */
	private Date publicationTime;
	/**
	 * 书籍简介
	 */
	private String introduce;
	/**
	 * 是否必读
	 */
	private String mustRead;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private Long createId;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 更新人
	 */
	private Long updateId;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 科目subject_type
	 */
	private String subject;
	/**
	 * 对应模块
	 */
	private Long moduleId;
	/**
	 * 学期semester_type
	 */
	private String term;
	/**
	 * 书籍版本（用于存储教材版本）book_version_type
2024/12/10现在又改了 教材版本扩展了 version_exp
	 */
	private Integer bookVersion;
	/**
	 * 书籍附件url
	 */
	private String attachmentUrl;
	/**
	 * 对应的格林书本ID
	 */
	private Long greenBookId;
	/**
	 * 对应的纳米盒书本ID
	 */
	private String nanoboxBookId;
	/**
	 * 版本号（修改成年份了）
	 */
	private String version;
	/**
	 * （书本资源管理/目录管理/关联资源任一内容修改，则取当前修改日期变为更新日期）
	 */
	private Date lastUpdate;
	/**
	 * 格林isbn
	 */
	private String isbn;
	/**
	 * 知识图谱id
	 */
	private Long knowledgeGraphId;

}
