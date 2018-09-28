package com.java.controller.firstresolve;

import com.java.model.DataResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author: Boris
 * Date: 2018/9/14 18:01
 * Copyright (C), 2017-2018
 * Description:
 */
@RestControllerAdvice
public class HandlerExceptionResolverHandler {
    /**
     * 用于处理通用异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public DataResult bindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();

        String errorMesssage = "校验失败:";

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage += fieldError.getDefaultMessage() + ", ";
        }

        return new DataResult("00000011", errorMesssage);
    }

}
