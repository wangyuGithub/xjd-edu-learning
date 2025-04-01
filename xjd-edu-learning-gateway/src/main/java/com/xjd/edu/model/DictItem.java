package com.xjd.edu.model;

import lombok.Data;

@Data
public class DictItem {

    private Integer id;
    private String dictCode;
    private String code;
    private String name;
    private String enabled;
    private String displayOrder;
    private String note;
    private String val;

}
