package com.shit.code.cloud.infrastructure.test;

import com.shit.code.cloud.infrastructure.test.expose.TestFeignClient;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/4/20
 **/
@RestController
public class TestController implements TestFeignClient {

    @Resource
    private TestService testService;

    @Override
    public String redisGet(String key) {
        return testService.redisGet(key);
    }

    @Override
    public String redisSet(String key, String value) {
        testService.redisSet(key, value);
        return "ok";
    }

}
