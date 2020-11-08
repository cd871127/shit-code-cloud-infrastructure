package com.shit.code.cloud.infrastructure.test;

import brave.Tracer;
import com.shit.code.cloud.infrastructure.test.mq.Sender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Random;

/**
 * @author Anthony
 * @date 10/4/20
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    private RedisTemplate<String, Test> redisTemplate;

    @Resource
    private Sender sender;

    @Resource
    private Tracer tracer;

    @GetMapping("cache")
    @Cacheable(cacheNames = "test", key = "'testCache'", cacheManager = "shitCodeCacheManager")
    public Object testCache() {
        log.error("test==");
        return new Random(System.currentTimeMillis()).nextInt();
    }

    @GetMapping("cache/delete")
    @CacheEvict(cacheNames = "test", key = "'testCache'", cacheManager = "shitCodeCacheManager")
    public Object testCache1() {
        log.error("testCache1");
        return new Random(System.currentTimeMillis()).nextInt();
    }

    @GetMapping("mq")
    public Object testmq() {
        sender.send("123123");
        return 1L;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Test implements Serializable {
        private static final long serialVersionUID = 1L;
        private Integer age;

        private String name;
    }

}
