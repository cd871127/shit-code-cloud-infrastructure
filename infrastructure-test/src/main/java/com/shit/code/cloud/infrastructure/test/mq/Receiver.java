package com.shit.code.cloud.infrastructure.test.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Anthony
 * @date 11/7/20
 **/
@Component
@Slf4j
@RabbitListener(queues = "testtrace")
public class Receiver {
    @RabbitHandler
    public void handler(String message) {
        log.info("接收消息：" + message);
    }
}
