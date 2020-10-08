package com.shit.code.cloud.infrastructure.test;

import com.shit.code.cloud.cache.annotation.MultiLevelCachePut;
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

    @MultiLevelCachePut(key = "'test'", ttl = 40000L)
    public String redisSet(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return value;
    }

    @MultiLevelCacheable(key = "'test'", ttl = 50000L)
    public String redisGet(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
