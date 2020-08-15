package com.shit.code.infrastructure.gateway.test;

import com.shit.code.infrastructure.gateway.dao.mapper.RouteMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {


    @Resource
    private RouteMapper routeMapper;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping("/db/{name}")
    Long test(@PathVariable("name") String name) {
        long start = System.currentTimeMillis();
        List<String> result = routeMapper.get(name);

        return System.currentTimeMillis() - start;
    }

    @GetMapping("redis/{key}/{value}")
    String test2(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return "ok";
    }

    @GetMapping("redis/{key}")
    String test2(@PathVariable("key") String key) {

        return redisTemplate.opsForValue().get(key);
    }


}
