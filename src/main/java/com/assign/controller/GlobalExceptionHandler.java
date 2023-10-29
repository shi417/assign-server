package com.assign.controller;

import com.assign.entity.common.ResponseResult;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler implements ErrorController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        // 可以根据需要构建自定义错误响应
        return new ResponseEntity<>(ResponseResult.failed(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}