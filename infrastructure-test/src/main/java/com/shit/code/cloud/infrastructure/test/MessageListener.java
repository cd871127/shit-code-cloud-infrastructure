package com.shit.code.cloud.infrastructure.test;


import brave.Tracer;
import com.shit.code.redis.spring.message.RedisMessage;
import com.shit.code.redis.spring.message.RedisMessageHandler;
import com.shit.code.redis.spring.message.RedisMessageListenerAdaptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Anthony
 * @date 11/7/20
 **/
@Slf4j
@Component
public class MessageListener extends RedisMessageListenerAdaptor {

    public MessageListener() {
        super((RedisMessageHandler<TestController.Test>) redisMessage -> {
            log.info("收到消息222:{}", redisMessage);
        }, "testTopic");
    }

    public static class H implements RedisMessageHandler<TestController.Test> {
        @Override
        public void handleMessage(RedisMessage<TestController.Test> redisMessage) {
            log.info("收到消息:{}", redisMessage);
        }
    }
}
