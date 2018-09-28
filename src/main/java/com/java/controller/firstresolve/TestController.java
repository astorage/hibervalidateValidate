package com.java.controller.firstresolve;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Boris
 * Date: 2018/9/14 15:57
 * Copyright (C), 2017-2018
 * Description:
 */
@RestController
public class TestController {

    @RequestMapping("validate/firstRequest")
    public String firstRequest() {
        return "Ok";
    }
}
