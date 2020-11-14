package com.shit.code.cloud.infrastructure.test;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Anthony
 * @date 11/14/20
 **/
@Component
@Slf4j
public class TestErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        log.info("error error error error");
        try {
            String bodyStr = Util.toString(response.body().asReader(Util.UTF_8));
            log.error("{}", bodyStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new IllegalArgumentException("123123123123123");
    }
}
