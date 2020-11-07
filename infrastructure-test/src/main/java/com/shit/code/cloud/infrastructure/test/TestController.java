package com.shit.code.cloud.infrastructure.test;

import brave.Tracer;
import brave.Tracing;
import brave.propagation.TraceContext;
import com.shit.code.cloud.infrastructure.test.mq.Sender;
import com.shit.code.redis.spring.message.TraceRedisMessage;
import com.shit.code.redis.spring.trace.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anthony
 * @date 10/4/20
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    private RedisTemplate<String, Test> redisTemplate;

    @Resource
    private Sender sender;

    @Resource
    private Tracer tracer;

    @GetMapping("cache")
    public Object testCache() {
        TraceContext.Injector<Map<String, String>> injector = Tracing.current().propagation().injector(new Setter());
        TraceRedisMessage<Test> redisMessage = new TraceRedisMessage<>();
        redisMessage.setBody(Test.builder().age(20).name("anthony").build());
        TraceContext traceContext = Tracing.currentTracer().currentSpan().context();
        Map<String, String> traceContextMap = new HashMap<>();
        injector.inject(traceContext, traceContextMap);
//        redisMessage.setTraceContextMap(traceContextMap);
        log.info("发布：{}", redisMessage);
        redisTemplate.convertAndSend("testTopic", redisMessage);
        return 1L;
    }

    @GetMapping("mq")
    public Object testmq() {
        sender.send("123123");
        return 1L;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Test implements Serializable {
        private static final long serialVersionUID = 1L;
        private Integer age;

        private String name;
    }

}
