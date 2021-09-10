package com.darwin.wasterecycling.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@Api
@RestController
public class TestController {

    @ApiOperation(value = "hello-api")
    @GetMapping("hello")
    public String hello(@ApiIgnore HttpSession session){
        return "hello "+session.getId();
    }
}
