package com.xjd.edu.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.security.Principal;

/**
 * 认证身份主体信息
 *
 * @author zlikun
 * @created 2022/2/16 10:30
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GamePrincipal implements Principal {

    public GamePrincipal(String name) {
        this.name = name;
    }

    /**
     * 认证身份标识（通常为用户ID）
     */
    private String name;
    /**
     * 续租时间戳（目前续租时间超过一天则触发续租动作）
     */
    private long renewTimestamp;

    @Override
    public String toString() {
        return this.name;
    }

}
