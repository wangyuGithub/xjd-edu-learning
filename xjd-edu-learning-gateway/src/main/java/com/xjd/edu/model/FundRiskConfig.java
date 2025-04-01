package com.xjd.edu.model;

import lombok.Data;

@Data
public class FundRiskConfig {

    /**
     * 资金权限类型
     */
    private Integer type;

    public FundRiskConfig(Integer type) {
        this.type = type;
    }

}
