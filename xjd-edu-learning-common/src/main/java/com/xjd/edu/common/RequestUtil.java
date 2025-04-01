package com.xjd.edu.common;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;
import java.util.Map.Entry;

@Slf4j
public class RequestUtil {

    /**
     * 将渠道platform信息存储致线程上下文中
     */
    //private static final ThreadLocal<PlatformConfigParamEnum> platformThreadLocal = new ThreadLocal<>();

    /*public static PlatformConfigParamEnum getPlatform() {
        return platformThreadLocal.get();
    }*/

    public static String getIpAdrress(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if (index != -1) {
                return XFor.substring(0, index);
            } else {
                return XFor;
            }
        }
        XFor = Xip;
        if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        if (StringUtils.isBlank(XFor) || Arrays.asList("127.0.0.1", "0:0:0:0:0:0:0:1").contains(XFor)) {
            XFor = getFirstNetworkAddress();
        }

        return XFor;
    }

    private static List<String> getNetworkAddress() {
        List<String> result = new ArrayList<>();
        Enumeration<NetworkInterface> netInterfaces;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = addresses.nextElement();
                    if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(':') == -1) {
                        result.add(ip.getHostAddress());
                    }
                }
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static Map<String, String> parseParameters(HttpServletRequest request) {
        if (null == request) {
            return null;
        }
        Map<String, String[]> paraMap = request.getParameterMap();
        if (CollectionUtil.isEmpty(paraMap)) {
            return null;
        }
        Map<String, String> resultMap = new HashMap<>(paraMap.size());
        for (Entry<String, String[]> entry : paraMap.entrySet()) {
            String[] values = entry.getValue();
            if (ArrayUtil.isNotEmpty(values)) {
                resultMap.put(entry.getKey(), values[0]);
            }
        }
        return resultMap;
    }

    /**
     * 将request中的参数转换成对象
     *
     * @param request
     * @param beanClass
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        //实例化传进来的类型
        T bean = beanClass.newInstance();
        //之前使用request.getParameter("name")根据表单中的name值获取value值
        //request.getParameterMap()方法不需要参数，返回结果为Map<String,String[]>，也是通过前台表单中的name值进行获取
        Map map = request.getParameterMap();
        //将Map中的值设入bean中，其中Map中的key必须与目标对象中的属性名相同，否则不能实现拷贝
        BeanUtils.populate(bean, map);
        return bean;
    }

    /*public static void setPlatform(PlatformConfigParamEnum platform) {
        platformThreadLocal.set(platform);
    }

    public static void clear() {
        platformThreadLocal.remove();
    }*/

    private static String getFirstNetworkAddress() {
        List<String> ipAddressList = getNetworkAddress();
        return CollectionUtil.isEmpty(ipAddressList) ? null : ipAddressList.get(0);

    }


    public static String getHost(HttpServletRequest request) {
        String referer = request.getHeader("referer");
        String refererTestEnv = request.getParameter("refererTestEnv");

        String myUrl = referer;
        if (StringUtils.isNoneEmpty(refererTestEnv)) {
            myUrl = refererTestEnv;
        }
        return getHost(myUrl);
    }

    public static String getHost(String urlString) {
        if (StringUtils.isEmpty(urlString)) {
            log.info("getHost urlString is null");
            return null;
        }
        String host = null;
        java.net.URL url;
        try {
            url = new java.net.URL(urlString);
            host = url.getHost();
        } catch (Exception e) {
            log.error("获取域名异常：", e);
        }
        return host;
    }

    public static Map<String, String> getParamerterMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>(10);
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String paraName = enumeration.nextElement();
            map.put(paraName, request.getParameter(paraName));
        }
        return map;

    }

    private static String getHeadersInfoWithJsonStr(HttpServletRequest request) {
        if (null == request) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        String key;
        String value;
        while (headerNames.hasMoreElements()) {
            key = headerNames.nextElement();
            value = request.getHeader(key);
            map.put(key, value);
        }
        return JSONUtil.toJsonStr(map);

    }

    public static String getHeadersInfoWithJsonStr(HttpServletRequest request, String... filterHeaderNames) {
        if (null == request) {
            return null;
        }
        if (ArrayUtil.isEmpty(filterHeaderNames)) {
            return getHeadersInfoWithJsonStr(request);
        }
        Map<String, String> map = new HashMap<>();
        String value;
        for (String headerName : filterHeaderNames) {
            value = request.getHeader(headerName);
            map.put(headerName, value);
        }
        return JSONUtil.toJsonStr(map);

    }


    public static Map<String, String> getUrlParams(String param) {
        Map<String, String> map = new HashMap<String, String>(0);
        if (StringUtils.isBlank(param)) {
            return map;
        }
        String[] params = param.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], p[1]);
            }
        }
        return map;
    }

}
