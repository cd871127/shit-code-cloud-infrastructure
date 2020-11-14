package com.shit.code.cloud.infrastructure.test;

import brave.Tracer;
import com.shit.code.cloud.foundation.data.dictionary.exposure.feign.DataDictionaryQueryClient;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private DataDictionaryQueryClient dataDictionaryQueryClient;

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

    @GetMapping("feign/{time}")
//    @TimeLimiter(name = "backendA")
    public Integer feign(@PathVariable(required = false) Integer time) {
        return dataDictionaryQueryClient.test(time == null ? 0 : time);
    }

    @GetMapping("exception/{time}")
    public Integer feign1(@PathVariable(required = false) Integer time) {
        if (time == 5) {
            throw new IllegalArgumentException();
        }
        return time;
    }


    @GetMapping("22")
    public String test123() {
        return dataDictionaryQueryClient.test2();
    }

    @GetMapping("11")
    public BigDecimal b() {
        return new BigDecimal("123.3");
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
