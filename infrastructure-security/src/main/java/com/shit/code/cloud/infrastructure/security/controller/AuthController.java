package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.test.expose.TestFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.shiro.mgt.SecurityManager;
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
//    @Resource
//    private TestFeignClient testClient;
//
//    @GetMapping("auth")
//    public ShitCodeHttpResponse<String> ok() {
//        return new ShitCodeHttpResponse<>("ok");
//    }
//
//    @GetMapping("auth2")
//    public ShitCodeHttpResponse<String> ok2() {
//        testClient.redisSet("aaaa", "11111");
//        log.info("test:{}", testClient.redisGet("aaaa"));
//        log.info("======哦啦啦");
//        return new ShitCodeHttpResponse<>("ok");
//    }
    @RequiresRoles({"asdfasdf"})
    @GetMapping("aaa")
    String test() {
        SecurityUtils.setSecurityManager(securityManager);
        SecurityUtils.getSubject().login(new UsernamePasswordToken("111", "111"));
        return "ok";
    }
}
