package com.shit.code.cloud.infrastructure.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anthonychen
 * @date 2020/10/14
 **/
@Slf4j
@RestController
public class AuthController {

    @GetMapping("auth")
    public String ok() {
        return "ok";
    }
}
