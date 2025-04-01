package com.xjd.edu.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum OsEnum {

    UNDEFINED(0,"UNDEFINED"),
    H5(1, "H5"),
    PC(2, "PC"),
    ANDROID(3, "ANDROID"),
    IOS(4, "IOS"),
    APPLET(5, "APPLET");

    private Integer type;
    private String msg;


    public static OsEnum parse(Integer type) {
        for (OsEnum e : OsEnum.values()) {
            if (Objects.equals(e.getType(), type)) {
                return e;
            }
        }
        return OsEnum.UNDEFINED;
    }


    public static Integer parseByClientInfo(String system) {
        for (OsEnum os : OsEnum.values()) {
            if (os.getMsg().equalsIgnoreCase(system)) {
                return os.getType();
            }
        }
        return OsEnum.UNDEFINED.getType();
    }


//    public static Integer parseByClientInfo(ClientInfo clientInfo) {
//        if (clientInfo == null) {
//            return OsEnum.UNDEFINED.getType();
//        }
//        String manufacturer = clientInfo.get_manufacturer();
//
//
//        //ios客户端固定参数
//        if (StringUtils.isNotEmpty(manufacturer)) {
//            if ("apple".equalsIgnoreCase(manufacturer.toLowerCase(Locale.getDefault()))) {
//                return IOS.getType();
//            }
//        }
//        for (OsEnum os : OsEnum.values()) {
//            if (os.getMsg().equalsIgnoreCase(clientInfo.get_system())) {
//                return os.getType();
//            }
//        }
//        return OsEnum.UNDEFINED.getType();
//    }

}
