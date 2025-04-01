package com.xjd.edu.common.utils;

import java.util.UUID;

/**
 * @author zlikun
 * @date 2021/06/30 17:19
 */
public class UuidUtil {

    public static final String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
