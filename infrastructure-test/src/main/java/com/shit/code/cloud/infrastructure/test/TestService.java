package com.shit.code.cloud.infrastructure.test;

import com.shit.code.cloud.cache.annotation.MultiLevelCacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/4/20
 **/
@Service
public class TestService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @MultiLevelCacheable(key = "test")
    public void redisSet(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String redisGet(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
