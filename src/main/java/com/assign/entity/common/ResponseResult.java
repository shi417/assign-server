package com.assign.entity.common;

import lombok.Builder;
import lombok.Data;

/**
 * ResponseResult
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/9/28.
 */
@Data
public class ResponseResult <T>{

    private static final Integer SUCCESS_CODE = 200;

    private static final Integer DEFAULT_FAILED_CODE = 500;

    private boolean success;
    private Integer code;
    private String message;
    private T data;

    public ResponseResult(){

    }

    private ResponseResult(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult(true, SUCCESS_CODE, (String) null, data);
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult(true, SUCCESS_CODE, (String) null, (Object) null);
    }

    public static <T> ResponseResult<T> success(T data, String message) {
        return new ResponseResult(true, SUCCESS_CODE, message, data);
    }

    public static <T> ResponseResult<T> failed() {
        return failed("Internal Error");
    }

    public static <T> ResponseResult<T> failed(String message) {
        return new ResponseResult(false, DEFAULT_FAILED_CODE, message, (Object) null);
    }

    public static <T> ResponseResult<T> failed(Integer code, String message) {
        return new ResponseResult(false, code, message, (Object) null);
    }

}
