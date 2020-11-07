//package com.shit.code.cloud.infrastructure.test;
//
//import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//
///**
// * @author Anthony
// * @date 11/7/20
// **/
//public class TestConfig {
//
//    @Bean
//    public RedisMessageListenerContainer container2(RedisConnectionFactory connectionFactory, MessageListenerAdapter redisListinser) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//
//        //订阅多个频道
//        container.addMessageListener(redisListinser, new PatternTopic("test1"));
////序列化对象（特别注意：发布的时候需要设置序列化；订阅方也需要设置序列化）
////        Jackson2JsonRedisSerializer seria = new Jackson2JsonRedisSerializer(Object.class);
////        ObjectMapper objectMapper = new ObjectMapper();
////        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
////        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
////        seria.setObjectMapper(objectMapper);
//        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
//        container.setTopicSerializer(fastJsonRedisSerializer);
//        return container;
//    }
//
//    @Bean
//    public MessageListenerAdapter redisListinser() {
//        return new MessageListenerAdapter(new MessageRecieve(), "handleMessage");
//    }
//}
