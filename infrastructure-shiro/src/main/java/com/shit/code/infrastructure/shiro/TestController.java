package com.shit.code.infrastructure.shiro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anthony Chen
 * @date 2020/7/9
 **/
@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping("olala")
    public String test() {
        return "123123";
    }
}
