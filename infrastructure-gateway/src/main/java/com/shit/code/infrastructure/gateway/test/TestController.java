package com.shit.code.infrastructure.gateway.test;

import com.shit.code.infrastructure.gateway.dao.mapper.RouteMapper;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;
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


    @GetMapping("/db/get/{name}")
    Long test(@PathVariable("name") String name) {
        long start = System.currentTimeMillis();
        List<String> result = routeMapper.get(name);

        return System.currentTimeMillis() - start;
    }

    @GetMapping("/db/add/{name}")
    Integer test11(@PathVariable("name") String name) {
        return routeMapper.insert(name);
    }


    @GetMapping("redis/{key}")
    String test2(@PathVariable("key") String key) {
        BoundHashOperations<String, String, Object> boundHashOperations = redisTemplate.boundHashOps(key);
        boundHashOperations.put("123", "123");
        boundHashOperations.put("456", "12aaa3");
        boundHashOperations.delete("123");
        System.out.println(boundHashOperations.get("456"));
        boundHashOperations.expire(Duration.ZERO);

        boundHashOperations.put("fff", "aaa");
        return "ook";
    }
}
