package com.shit.code.infrastructure.gateway;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

@Configuration
@ConditionalOnClass(RedisOperations.class)
//@EnableConfigurationProperties(RedisProperties.class)
public class RedisInitializer implements Ordered {

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Bean
//    @ConditionalOnBean(value = {RedisTemplate.class})
    public void test() {
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setStringSerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
