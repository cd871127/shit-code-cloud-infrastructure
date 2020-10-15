package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.client.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shit.code.cloud.spring.response.ShitCodeHttpResponse;

import javax.annotation.Resource;

/**
 * @author anthonychen
 * @date 2020/10/14
 **/
@Slf4j
@RestController
@RestControllerAdvice
public class AuthController {

    @Resource
    private TestService testService;

    @GetMapping("auth")
    public ShitCodeHttpResponse<String> ok() {
        return new ShitCodeHttpResponse<>("ok");
    }

    @GetMapping("auth2")
    public ShitCodeHttpResponse<String> ok2() {
        testService.redisSet("aaaa", "11111");
        log.info("test:{}", testService.redisGet("aaaa"));
        log.info("======哦啦啦");
        return new ShitCodeHttpResponse<>("ok");
    }
}
