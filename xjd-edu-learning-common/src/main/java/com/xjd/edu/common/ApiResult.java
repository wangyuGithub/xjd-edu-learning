package com.xjd.edu.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * API响应结果类，
 * code 状态码，小于0表示系统错误，0表示无错误，大于0表示业务错误
 * #isSuccessful() 判断响应是否正常，返回true表示请求响应正常，可以直接获取响应结果，false表示请求出错，具体错误信息参考 code 和 message 字段
 * #value() 返回响应结果
 *
 * @author zhanglikun
 * @date 2021/04/14 15:17
 */
@Data
@Accessors(chain = true)
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    // 响应实体
    private T value;
    // 响应状态码
    private int code = ApiResultCode.OK.getCode();
    // 响应状态码描述信息
    private String message;
    // 分页时查询总数
    private Long rows;

    public ApiResult() {
    }

    public ApiResult(T value) {
        this.value = value;
    }

    public ApiResult(@NotNull ApiResultCode code, T value) {
        this(code.getCode(), code.getMessage(), value);
    }

    public ApiResult(int code, String message, T value) {
        this.value = value;
        this.code = code;
        this.message = message;
    }

    /**
     * 成功响应
     *
     * @param value
     * @param <T>
     * @return
     */
    public static final <T> ApiResult<T> success(T value) {
        return new ApiResult<>(value);
    }

    /**
     * 成功响应，无返回值
     *
     * @param <T>
     * @return
     */
    public static final <T> ApiResult<T> success() {
        return success(null);
    }

    /**
     * 失败响应
     *
     * @param code
     * @param message
     * @param value
     * @param <T>
     * @return
     */
    public static final <T> ApiResult<T> error(int code, String message, T value) {
        return new ApiResult<T>(code, message, value);
    }

    /**
     * 失败响应，使用预设状态码
     *
     * @param code
     * @param value
     * @param <T>
     * @return
     */
    public static final <T> ApiResult<T> error(@NotNull ApiResultCode code, T value) {
        return error(code.getCode(), code.getMessage(), value);
    }

    /**
     * 失败响应
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static final <T> ApiResult<T> error(int code, String message) {
        return error(code, message, null);
    }


    /**
     * 失败响应，使用预设状态码，接口返回值为NULL
     *
     * @param code
     * @param <T>
     * @return
     */
    public static final <T> ApiResult<T> error(@NotNull ApiResultCode code) {
        return error(code, null);
    }
    /**
     * 失败响应，使用预设状态码，接口返回值为NULL
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static final <T> ApiResult<T> error(@NotNull String msg) {
        return error(500, msg);
    }

    /**
     * 当前响应状态是否是成功状态（调用没有任何错误，且返回结果符合接口契约）
     *
     * @return
     */
    @JsonIgnore
    public boolean isSuccessful() {
        return this.code == ApiResultCode.OK.getCode();
    }

    /**
     * 接口响应实体
     */
    public T value() {
        return this.getValue();
    }

    public ApiResult<T> value(T value) {
        this.setValue(value);
        return this;
    }

    /**
     * 接口响应状态码
     */
    public int code() {
        return this.getCode();
    }

    public ApiResult<T> code(int code) {
        this.setCode(code);
        return this;
    }

    public ApiResult<T> code(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
        return this;
    }

    public ApiResult<T> code(@NotNull ApiResultCode code) {
        return this.code(code.getCode(), code.getMessage());
    }

    /**
     * 接口响应状态码描述信息
     */
    public String message() {
        return this.getMessage();
    }

    public ApiResult<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 分页查询时记录查询记录总数
     *
     * @return
     */
    public Long rows() {
        return this.getRows();
    }

    public ApiResult<T> rows(Long rows) {
        this.setRows(rows);
        return this;
    }

}
