package com.xjd.edu.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 返回结果封装
 */
@Slf4j
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int status;

    private String msg = "";

    private T data = null;

    public Result(int status) {
        this.status = status;
    }

    public Result(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Result() {
        super();
    }

    public Result msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result data(T data) {
        this.data = data;
        return this;
    }

//    public ResultV2 data(String key, Object data) {
//        Map<String, Object> map = new HashMap<>();
//        map.put(key, data);
//        this.data = map;
//        return this;
//    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.SUCCESS);
        return result;
    }

    public static <T> Result<T> successData(T data) {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.SUCCESS);
        result.setData(data);
        result.setMsg("success");
        return result;
    }


    public static <T> Result<T> newResultStatus(Integer status) {
        Result<T> result = new Result<>();
        result.setStatus(status);
        return result;
    }

    public static <T> Result<T> error(int status, String msg) {
        Result<T> result = new Result<>();
        result.setStatus(status);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> error() {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.ERROR);
        return result;
    }

    public static <T> Result<T> dataError() {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.DATAEXCPTION);
        return result;
    }

    /**
     * 未登录
     *
     * @return
     */
    public static <T> Result<T> noLogin() {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.NOLOGIN);
        result.setMsg("登录状态已失效,请重新登录!");
        return result;
    }


//    /**
//     * 被挤下线
//     *
//     * @return
//     */
//    public static <T> ResultV2<T> beOffline() {
//        ResultV2<T> result = new ResultV2<>();
//        result.setStatus(ResultStatus.NOLOGIN);
//        result.setMsg("您正在使用另一台设备登录此账号!");
//        result.data("errcode", 4001);
//        return result;
//    }


    public static <T> Result<T> userBanned() {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.USER_BANNED);
        result.setMsg("用户被封禁!");
        return result;
    }


    public static <T> Result<T> accessDeny() {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.ACCESS_DENY);
        return result;
    }

    /**
     * 版本太低
     *
     * @return
     */
    public static <T> Result<T> versionsLow() {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.VERSIONS_LOW);
        result.setMsg("当前APP版本过低，请更新APP版本!");
        return result;
    }

    /**
     * 自定义msg
     *
     * @return
     */
    public static <T> Result<T> gloBalResult(String msg) {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.ERROR);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> newUser() {
        Result<T> result = new Result<>();
        result.setStatus(ResultStatus.NEWUSER);
        return result;
    }

}
