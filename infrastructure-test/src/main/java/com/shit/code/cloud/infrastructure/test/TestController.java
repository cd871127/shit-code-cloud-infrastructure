package com.shit.code.cloud.infrastructure.test;

import com.shit.code.cloud.infrastructure.test.expose.SubjectClient;
import com.shit.code.cloud.infrastructure.test.expose.TestFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/4/20
 **/
@RestController
@Slf4j
public class TestController implements TestFeignClient {

    @Resource
    private TestService testService;

    @Resource
    private SubjectClient subjectClient;

    @GetMapping("test")
    public Subject test() {
        log.info("start");
        Object o = subjectClient.findById(4);
        log.info("end:{}", o);
        Object o2 = subjectClient.findById2(4);
        log.info("end2:{}", o2);
        return (Subject) o;
    }

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
