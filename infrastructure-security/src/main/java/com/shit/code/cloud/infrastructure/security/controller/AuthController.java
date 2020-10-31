package com.shit.code.cloud.infrastructure.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author anthonychen
 * @date 2020/10/14
 **/
@Slf4j
@RestController
public class AuthController {


    @Resource
    private SecurityManager securityManager;

    @GetMapping("aaa")
    String test() {
        SecurityUtils.setSecurityManager(securityManager);
        SecurityUtils.getSubject().login(new UsernamePasswordToken("111", "111"));
        return "ok";
    }
}
