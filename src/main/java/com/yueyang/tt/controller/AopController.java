package com.yueyang.tt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-18 10:59
 **/
@RestController
@RequestMapping("/aop")
@Slf4j
@Validated
@Api(value = "hello", tags = "hello")
public class AopController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value = "hello", notes = "hello", httpMethod = "GET")
    public String sayHello(String name) {
        System.out.println("实际方法执行");
        return "hello" + name;
    }
}

