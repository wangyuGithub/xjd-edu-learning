package com.xjd.edu.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum UserForbidTypeEnum {

    ORDER(2, "封禁接单"),
    LOGIN(1, "封禁用户"),
    NEWPRICE(3, "限制新客价"),
    QUICKORDER(4, "限制秒接"),
    CLOSE(5, "限制秒接"),
    RECHARGE(6, "禁止充值"),
    CONSUMER(7, "禁止消费"),
    CONVERT(8, "禁止兑换"),
    WITHDRAW(9, "禁止提现"),
    USELESS(0, "未定义的功能禁用");

    private Integer type;
    private String msg;


    public static UserForbidTypeEnum parse(Integer type) {
        for (UserForbidTypeEnum typeEnum : UserForbidTypeEnum.values()) {
            if (Objects.equals(typeEnum.getType(), type)) {
                return typeEnum;
            }
        }
        return null;
    }

    public static String getMsgByType(Integer type) {
        UserForbidTypeEnum userForbidTypeEnum = parse(type);
        return userForbidTypeEnum == null ? null : userForbidTypeEnum.getMsg();
    }

}
