package com.shit.code.cloud.infrastructure.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author Anthony
 * @date 10/4/20
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("cache")
//    @Cacheable(cacheNames = "test")
    public Object testCache() {
        redisTemplate.convertAndSend("test1", Test.builder().age(20).name("anthony"));
        return 1L;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Test implements Serializable {
        private Integer age;

        private String name;
    }

}
