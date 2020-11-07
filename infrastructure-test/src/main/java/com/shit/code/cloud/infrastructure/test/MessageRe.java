package com.shit.code.cloud.infrastructure.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Anthony
 * @date 11/7/20
 **/
@Slf4j
public class MessageRe {

    public void handleMessage(Object o) {
        log.info("{}", o);
    }
}
