package com.shit.code.cloud.infrastructure.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Anthony
 * @date 11/7/20
 **/
@Slf4j
public class MessageRecieve {

    public void handleMessage(Object message) {
        log.info("收到消息：{}", message);
    }
}
