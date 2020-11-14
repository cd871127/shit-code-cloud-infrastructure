package com.shit.code.cloud.infrastructure.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shit.code.common.exception.BusinessException;
import com.shit.code.common.web.response.CommonHttpResponse;
import com.shit.code.common.web.response.ExceptionHttpResponse;
import com.shit.code.common.web.response.HttpSuccessEnum;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

/**
 * @author Anthony
 * @date 11/14/20
 **/
@Component
@Slf4j
public class TestDecoder implements Decoder {

    @SneakyThrows
    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        String bodyStr = Util.toString(response.body().asReader(Util.UTF_8));
        log.debug("Feign调用返回:{}", bodyStr);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        CommonHttpResponse commonHttpResponse = objectMapper.readValue(bodyStr, CommonHttpResponse.class);
        if (HttpSuccessEnum.SUCCESS.getCode().equals(commonHttpResponse.getCode())) {
            return commonHttpResponse.getData();
        }

        log.error("Feign调用异常:{}", bodyStr);
        ExceptionHttpResponse exceptionHttpResponse = objectMapper.readValue(bodyStr, ExceptionHttpResponse.class);
        throw new DecodeException(500, "Feign调用异常", response.request(), new BusinessException(exceptionHttpResponse));
    }
}
