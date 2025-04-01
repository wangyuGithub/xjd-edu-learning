package com.xjd.edu.common.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.Data;

import java.io.Serializable;


/**
 * 字典条目表
 *
 * @author wangbin
 * @date 2018-12-24 17:29:19
 */
@Data
public class DictItem implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    @ExcelIgnore
    private Integer id;
    //t_dict表id
    @ExcelIgnore
    private String dictCode;
    //字典项编码
    @Excel(name = "字典项code", width = 20)
    private String code;
    //字典项名称
    @Excel(name = "字典项名称", width = 20)
    private String name;
    //是否启用，1：启用；0：禁用
    @Excel(name = "是否启用(1:启用,0:禁用)", width = 30)
    private String enabled;
    //显示顺序，值越小越靠前显示
    @Excel(name = "排序", width = 20)
    private String displayOrder;
    //扩展属性键描述
    @Excel(name = "注释说明",width = 30)
    private String note;
    //字典值
    @Excel(name = "字典项值",width = 30)
    private String val;
    //字典项值(灰度)
    @Excel(name = "字典项值(灰度)",width = 30)
    private String grayVal;
    //标签(流量染色)
    @Excel(name = "标签(流量染色)",width = 30)
    private String label;


}
