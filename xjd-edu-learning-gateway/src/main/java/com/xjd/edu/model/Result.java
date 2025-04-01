package com.xjd.edu.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果封装
 *
 * @see ResultV2
 */
@Slf4j
@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    private int status;

    private String msg = "";

    private Object data = null;

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

    public static Result success() {
        Result result = new Result();
        result.setStatus(ResultStatus.SUCCESS);
        return result;
    }

    public static Result successData(Object obj) {
        return success().data(obj);
    }

    public static Result newResultStutus(Integer status) {
        Result result = new Result();
        result.setStatus(status);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setStatus(ResultStatus.ERROR);
        return result;
    }

    public static Result dataError() {
        Result result = new Result();
        result.setStatus(ResultStatus.DATAEXCPTION);
        return result;
    }

    /**
     * 未登录
     *
     * @return
     */
    public static Result noLogin() {
        Result result = new Result();
        result.setStatus(ResultStatus.NOLOGIN);
        result.setMsg("登录状态已失效,请重新登录!");
        return result;
    }

    /**
     * 被挤下线
     *
     * @return
     */
    public static Result beOffline() {
        Result result = new Result();
        result.setStatus(ResultStatus.NOLOGIN);
        result.setMsg("您正在使用另一台设备登录此账号!");
        result.data("errcode", 4001);
        return result;
    }

    public static Result userBanned() {
        Result result = new Result();
        result.setStatus(ResultStatus.USER_BANNED);
        result.setMsg("用户被封禁!");
        return result;
    }

    public static Result accessDeny() {
        Result result = new Result();
        result.setStatus(ResultStatus.ACCESS_DENY);
        return result;
    }

    /**
     * 版本太低
     *
     * @return
     */
    public static Result versionsLow() {
        Result result = new Result();
        result.setStatus(ResultStatus.VERSIONS_LOW);
        result.setMsg("当前APP版本过低，请更新APP版本!");
        return result;
    }

    /**
     * 自定义msg
     *
     * @return
     */
    public static Result gloBalResult(String msg) {
        Result result = new Result();
        result.setStatus(ResultStatus.ERROR);
        result.setMsg(msg);
        return result;
    }

    public static Result newUser() {
        Result result = new Result();
        result.setStatus(ResultStatus.NEWUSER);
        return result;
    }

    public Result msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result data(Object data) {
        this.data = data;
        return this;
    }

    public Result data(String key, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, data);
        this.data = map;
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
