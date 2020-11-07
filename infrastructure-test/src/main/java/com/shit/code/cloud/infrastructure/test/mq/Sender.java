package com.shit.code.cloud.infrastructure.test.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 11/7/20
 **/
@Component
@Slf4j
public class Sender {

    @Resource
    AmqpTemplate rabbitmqTemplate;

    public void send(String message) {
        log.info("发送消息：" + message);
        rabbitmqTemplate.convertAndSend("testtrace", message);
    }
}
