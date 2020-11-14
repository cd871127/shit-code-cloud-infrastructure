package com.shit.code.cloud.foundation.data.dictionary.controller;

import com.shit.code.cloud.foundation.data.dictionary.exposure.feign.DataDictionaryQueryClient;
import com.shit.code.common.exception.BusinessException;
import com.shit.code.common.exception.BusinessExceptionEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anthony
 * @date 11/14/20
 **/
@RequestMapping("/dictionary")
@RestController
public class DataDictionaryQueryController implements DataDictionaryQueryClient {

    @Value("${server.port:9999}")
    private Integer port;

    @Override
    public Integer test(Integer time) {
        if (time == 4) {
            throw new IllegalArgumentException();
        }
        if (time == 3) {
            throw new BusinessException(BusinessExceptionEnum.ERR_DATA_NOT_EXIST);
        }
        return port;
    }

    @Override
    public String test2() {
        return port.toString();
    }
}
