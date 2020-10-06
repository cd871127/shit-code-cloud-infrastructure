package com.shit.code.cloud.infrastructure.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/4/20
 **/
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("redis/{key}")
    public String redisGet(@PathVariable(name = "key") String key) {
        return testService.redisGet(key);
    }

    @PostMapping("redis/{key}/{value}")
    public String redisSet(@PathVariable String key, @PathVariable String value) {
        testService.redisSet(key, value);
        return "ok";
    }

}
