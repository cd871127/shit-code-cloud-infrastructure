package com.shit.code.cloud.infrastructure.test;


import com.shit.code.redis.spring.message.RedisMessageHandler;
import com.shit.code.redis.spring.message.RedisMessageListenerAdaptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * https://www.codercto.com/a/26133.html  傳播trace
 *
 * @author Anthony
 * @date 11/7/20
 **/
@Slf4j
@Component
public class MessageListener extends RedisMessageListenerAdaptor {
    public MessageListener() {
        super((RedisMessageHandler<TestController.Test>) test -> {
            log.info("收到消息：{}", test);
        }, "testTopic");
    }


}
