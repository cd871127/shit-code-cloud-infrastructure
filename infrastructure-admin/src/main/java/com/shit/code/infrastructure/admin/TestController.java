package com.shit.code.infrastructure.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anthony Chen
 * @date 2020/8/13
 **/
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
//    @Value("${test.test}")
    private String test;

    @GetMapping("test")
    public String test1(){
        return test;
    }
}
