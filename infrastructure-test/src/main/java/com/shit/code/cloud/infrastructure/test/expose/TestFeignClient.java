package com.shit.code.cloud.infrastructure.test.expose;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author anthonychen
 * @date 2020/10/15
 **/
@FeignClient(name = "infrastructure-test")
public interface TestFeignClient {
    @GetMapping("redis/{key}")
    String redisGet(@PathVariable(name = "key") String key);

    @PostMapping("redis/{key}/{value}")
    String redisSet(@PathVariable String key, @PathVariable String value);
}
