//package com.xjd.edu.user.controller.login.utils;
//
//import cn.hutool.extra.servlet.ServletUtil;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.xjd.edu.common.enums.AppType;
//import com.xjd.edu.common.model.login.LoginModel;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.beanutils.BeanUtils;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Base64;
//import java.util.Collections;
//import java.util.Map;
//
///**
// * @author zsw
// * @description:
// * @date 2021-03-08 15:32:18
// */
//@Slf4j
//public final class LoginUtil { // NOPMD
//
//    private static final ObjectMapper mapper = new ObjectMapper();
//    private static final Base64.Decoder decoder = Base64.getDecoder();
//
//    public static void setClientInfo(HttpServletRequest request, LoginModel loginModel) {
//        try {
//            loginModel.setIp(getIpAddress(request));
//            final Map<String, String> map = ServletUtil.getParamMap(request);
//            // 兼容客户端ClientInfo改为使用Header传值逻辑
//            map.putAll(getClientInfoFromHeader(request));
//            //将Map中的值设入bean中，其中Map中的key必须与目标对象中的属性名相同，否则不能实现拷贝
//            ClientInfo clientInfo = new ClientInfo();
//            // 记录AppType
//            clientInfo.setAppType(AppType.of(request.getIntHeader("X-App-Type")));
//            BeanUtils.populate(clientInfo, map);
//            loginModel.setClientInfo(clientInfo);
//        } catch (Exception e) {
//            log.error("get clientInfo error", e);
//        }
//    }
//
//    public static String getIpAddress(HttpServletRequest request) {
//        return ServletUtil.getClientIP(request, "X-Real-IP");
//    }
//
//    public static void setClientInfoForPloy(HttpServletRequest request) {
//        try {
//            String ip = getIpAddress(request);
//            final Map<String, String> map = ServletUtil.getParamMap(request);
//            // 兼容客户端ClientInfo改为使用Header传值逻辑
//            map.putAll(getClientInfoFromHeader(request));
//            //将Map中的值设入bean中，其中Map中的key必须与目标对象中的属性名相同，否则不能实现拷贝
//            ClientInfo clientInfo = new ClientInfo();
//            BeanUtils.populate(clientInfo, map);
//            // 记录AppType
//            clientInfo.setAppType(AppType.of(request.getIntHeader("X-App-Type")));
//        } catch (Exception e) {
//            log.error("setClientInfoForPloy get clientInfo error", e);
//        }
//    }
//
//    public static String getDeviceID(HttpServletRequest request) {
//        try {
//            final Map<String, String> map = ServletUtil.getParamMap(request);
//            // 兼容客户端ClientInfo改为使用Header传值逻辑
//            map.putAll(getClientInfoFromHeader(request));
//            //将Map中的值设入bean中，其中Map中的key必须与目标对象中的属性名相同，否则不能实现拷贝
//            ClientInfo clientInfo = new ClientInfo();
//            BeanUtils.populate(clientInfo, map);
//            return clientInfo.get_deviceID_SM();
//        } catch (Exception e) {
//            log.error("getDeviceID get get_deviceID_SM error", e);
//        }
//        return "";
//    }
//
//    public static Map<String, String> getClientInfoFromHeader(HttpServletRequest request) {
//        final String s = request.getHeader("X-Client-Info");
//        if (!StringUtils.hasText(s)) {
//            return Collections.emptyMap();
//        }
//        try {
//            return mapper.readValue(decoder.decode(s), new TypeReference<Map<String, String>>() {
//
//            });
//        } catch (Exception e) {
//            log.error("Header指定的ClientInfo信息 {} 格式错误", s, e);
//            return Collections.emptyMap();
//        }
//    }
//
//
//}
