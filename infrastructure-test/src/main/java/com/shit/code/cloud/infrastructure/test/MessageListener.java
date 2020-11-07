package com.shit.code.cloud.infrastructure.test;


import brave.Span;
import brave.Tracer;
import brave.Tracing;
import brave.propagation.TraceContext;
import brave.propagation.TraceContextOrSamplingFlags;
import com.shit.code.redis.spring.message.*;
import com.shit.code.redis.spring.trace.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;

import static brave.Span.Kind.CONSUMER;

/**
 * https://www.codercto.com/a/26133.html  傳播trace
 *
 * @author Anthony
 * @date 11/7/20
 **/
@Slf4j
@Component
public class MessageListener extends TraceRedisMessageListenerAdaptor {

    @Resource
    private Tracer outTrace;

    public MessageListener() {

        super((TraceRedisMessageHandler<TestController.Test>) redisMessage -> {
//            ApplicationContext applicationContext = SpringContextUtil.getContext();
//            Tracer tracer = applicationContext.getBean(Tracer.class);
            TraceContext.Extractor<Map<String, String>> extractor = Tracing.current().propagation().extractor(new Getter());
            TraceRedisMessage<TestController.Test> testTraceRedisMessage = (TraceRedisMessage<TestController.Test>) redisMessage;
            Span span;
            Tracer tracer = Tracing.currentTracer();
            if (MapUtils.isEmpty(testTraceRedisMessage.getTraceContextMap())) {
                span = tracer.nextSpan();
            } else {
                TraceContextOrSamplingFlags extracted = extractor.extract(testTraceRedisMessage.getTraceContextMap());
                span = tracer.nextSpan(extracted);
            }
            TraceContextOrSamplingFlags extracted2 = extractor.extract(Collections.emptyMap());
            log.info("============{}", tracer.nextSpan(extracted2));
//            Span span = extracted.context() != null ? tracer.joinSpan(extracted.context()) : tracer.nextSpan(extracted);

            if (!span.isNoop()) {
                span.kind(CONSUMER).start();
                //10
                String service = "olalaservice";
                String method = "testmethod";
                span.kind(CONSUMER);
                span.name(service + "/" + method);
                span.remoteIpAndPort("192.168.2.9", 8080);
//                InetSocketAddress remoteAddress = netInterface.getInetAddresses();
//                span.remoteIpAndPort(
//                        remoteAddress.getAddress() != null ? remoteAddress.getAddress().getHostAddress() : remoteAddress.getHostName(),remoteAddress.getPort());
            }

//            span = tracer.nextSpanWithParent(span);
            try (Tracer.SpanInScope scope = tracer.withSpanInScope(span)) {
                log.info("收到消息222:{}", redisMessage);
                log.info("parentId:{} spanId:{}", span.context().parentIdString(), span.context().spanIdString());
            } finally {
                span.finish();
            }
        }, "testTopic");
    }

    public static class H implements RedisMessageHandler<TestController.Test> {
        @Override
        public void handleMessage(RedisMessage<TestController.Test> redisMessage) {
            log.info("收到消息:{}", redisMessage);
        }
    }
}
