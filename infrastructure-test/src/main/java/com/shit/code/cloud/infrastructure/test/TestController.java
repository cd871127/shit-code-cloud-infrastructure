package com.shit.code.cloud.infrastructure.test;

import com.shit.code.cloud.infrastructure.test.mq.Sender;
import com.shit.code.redis.spring.message.RedisMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
    private RedisTemplate<String, Test> redisTemplate;

    @Resource
    private Sender sender;

    @GetMapping("cache")
    public Object testCache() {
        RedisMessage<Test> redisMessage = new RedisMessage<>(Test.builder().age(20).name("anthony").build());
        log.info("发布：{}", redisMessage);
        redisTemplate.convertAndSend("testTopic", redisMessage);
        return 1L;
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
