package com.wei.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试模块")
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/hello")
    @ApiOperation(value = "hello")
    public String hello(){
        return "8081";
    }
}
