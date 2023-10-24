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
    private String code;

    private String msg;

    private T data;

    public ResponseResult(){

    }

    public ResponseResult(String code ,String msg){
        this.code = code;
        this.msg = msg;
    }
}
