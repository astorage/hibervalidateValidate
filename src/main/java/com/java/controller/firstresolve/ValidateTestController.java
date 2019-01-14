package com.java.controller.firstresolve;

import com.java.model.dto.StudentDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Author: Boris
 * Date: 2018/9/14 16:04
 * Copyright (C), 2017-2018
 * Description:
 */
@RestController
public class ValidateTestController {
    /**
     * 使用@RequestBody标签 必须使用application/json请求，不然会报415
     * 只能接收 application/json的数据 post请求
     * @param studentDTO
     * @return
     */
    @RequestMapping(value = "/validate/validateObject")
    public String validateObject( @RequestBody StudentDTO studentDTO) {
        return studentDTO.toString();
    }

    /**
     * 使用@RequestBody标签 必须使用application/json请求，不然会报415，不能使用HibernateValidate校验参数
     * 只能接收 application/json的数据 post请求, 参数校验有效，使用了 BizExceptionHandler功能
     * @param studentDTO
     * @return
     */
    @RequestMapping(value = "/validate/validateObject1")
    public String validateObject1( @RequestBody @Validated StudentDTO studentDTO) {
        return studentDTO.toString();
    }

    /**
     * 参数校验都通过正常处理。如果有参数没有校验通过返回400，并说是前端问题，使用 HandlerExceptionResolverHandler功能
     * 不用@RequestBody 标签不能接收application/json格式的请求，报"校验失败:hobbies不能为空, id不能为空, name不能为空,"
     * 只能接收application/x-www-form-urlencoded格式的请求，校验有效。
     * @param studentDTO
     * @return
     */
    @RequestMapping(value = "/validate/validateObject2")
    public String validateObject2( @Validated StudentDTO studentDTO) {
        return studentDTO.toString();
    }

    /**
     * 没使用@RequestBody标签，请求需要用application/x-www-form-urlencoded格式，controller才能获取到参数
     * 单个参数，不能用HibernateValidate校验，如下，是无效的
     * 单个简单参数的验证可以通过手工if判断
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/validate/validateObject3")
    public String validateObject3( @NotBlank String name) {
        return name;
    }

    /**
     * 通过@RequestParam，如果为空，会抛出异常警告 org.springframework.web.bind.MissingServletRequestParameterException: Required String parameter 'name' is not present
     * 可以通过拦截来处理
     * @param name
     * @return
     */
    @RequestMapping(value = "/validate/validateObject4")
    public String validateObject4( @RequestParam String name, @RequestParam Integer age) {
        return name + age;
    }



    @RequestMapping(value = "/validate/validateObject5")
    public String validateObject5( @Valid StudentDTO studentDTO) {
        return studentDTO.toString();
    }
}
