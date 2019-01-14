package com.java.controller.firstresolve;

import com.java.model.DataResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author: Boris
 * Date: 2018/9/27 20:00
 * Copyright (C), 2017-2018
 * Description:
 */
@RestControllerAdvice
public class MissingServletRequestParameterExceptionHandler {

    /**
     * 用于处理通用异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    public DataResult bindException(MissingServletRequestParameterException e) {
        String paramName = e.getParameterName();

        String errorMesssage = "校验失败:";

       errorMesssage += paramName + "不能为空！";

        return new DataResult("00000011", errorMesssage);
    }
}
