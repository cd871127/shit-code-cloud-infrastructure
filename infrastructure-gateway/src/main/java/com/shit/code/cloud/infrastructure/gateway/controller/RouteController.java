package com.shit.code.cloud.infrastructure.gateway.controller;

import brave.Span;
import brave.Tracer;
import brave.propagation.CurrentTraceContext;
import brave.propagation.TraceContext;

import com.shit.code.cloud.infrastructure.gateway.entity.AccessoryEntity;
import com.shit.code.cloud.infrastructure.gateway.service.RouteService;
import com.shit.code.cloud.infrastructure.gateway.thread.ForkJoinPoolWrapper;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory;
import org.springframework.cloud.gateway.support.Configurable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping("/route")
public class RouteController {

    @Resource
    private RouteService routeService;

    @Resource
    private List<GatewayFilterFactory<?>> gatewayFilters;

    @Resource
    private List<RoutePredicateFactory<?>> routePredicates;

    private ConcurrentHashMap<Class<?>, Cache> classCache = new ConcurrentHashMap<>(32);
    @Resource
    private Tracer tracer;
    @Resource
    private CurrentTraceContext.Builder sleuthCurrentTraceContextBuilder;

    /**
     * 查询可用filter列表
     *
     * @return
     */
    @GetMapping("filters")
    public List<AccessoryEntity> filters() {
        List<AccessoryEntity> list = gatewayFilters.parallelStream()
                .map(this::extractAccessoryInfo)
                .collect(Collectors.toList());
        return list;
    }

    /**
     * 查询可用predicate列表
     *
     * @return
     */
    @GetMapping("predicates")
    public List<AccessoryEntity> predicates() throws ExecutionException, InterruptedException, TimeoutException {
//        CurrentTraceContext.wrap()
//
//        log.info("tracer:{}", tracer.currentSpan().context().traceIdString());
//        log.info("MDC:{}", MDC.get("X-B3-TraceId"));
//        TraceContext context = tracer.currentSpan().context();
//        Map<String, String> mdcContext = MDC.getCopyOfContextMap();
//        ExecutorService forkJoinPool =  sleuthCurrentTraceContextBuilder.build().executorService(new ForkJoinPool(6));
//        ForkJoinTask<List<AccessoryEntity>> forkJoinTask = (ForkJoinTask<List<AccessoryEntity>>)forkJoinPool.submit(
//                () -> routePredicates.parallelStream()
////                () -> ThreadWrapper.wrap(routePredicates.parallelStream(), mdcContext)
//                        .map(this::extractAccessoryInfo)
//                        .peek(accessoryEntity -> {
//                            log.info("tracer:{}", tracer.currentSpan().context().traceIdString());
//                            log.info("MDC:{}", MDC.get("X-B3-TraceId"));
//                        })
//                        .collect(Collectors.toList()));
//        List<AccessoryEntity> list = forkJoinTask.get(3000, TimeUnit.SECONDS);


        log.info("tracer:{}", tracer.currentSpan().context().traceIdString());
        log.info("MDC:{}", MDC.get("X-B3-TraceId"));
        TraceContext context = tracer.currentSpan().context();
        Span span = tracer.currentSpan();
        Map<String, String> mdcContext = MDC.getCopyOfContextMap();
        ForkJoinPool forkJoinPool = new ForkJoinPoolWrapper(3);
        ForkJoinTask<List<AccessoryEntity>> forkJoinTask = forkJoinPool.submit(
//                () -> ThreadWrapper.wrap(routePredicates.parallelStream(), mdcContext)
                () -> routePredicates.parallelStream()
//                        .peek(a -> tracer.withSpanInScope(span))
//                        .peek(a -> tracer.withSpanInScope(span))
                        .map(this::extractAccessoryInfo)
                        .peek(accessoryEntity -> {
//                            log.info("tracer:{}", tracer.currentSpan().context().traceIdString());
                            log.info("MDC:{}", MDC.get("X-B3-TraceId"));
                        })
                        .collect(Collectors.toList()));


        List<AccessoryEntity> list = forkJoinTask.get(3000, TimeUnit.SECONDS);


//        List<AccessoryEntity> list = routePredicates.parallelStream()
//                .map(this::extractAccessoryInfo)
//                .peek(accessoryEntity -> log.info("{}", accessoryEntity))
//                .collect(Collectors.toList());
        return list;
    }

    /**
     * 提取路由附属组件信息
     *
     * @return
     */
    private <T> AccessoryEntity extractAccessoryInfo(T accessory) {
        Configurable<?> configurable = (Configurable<?>) accessory;
        Class<?> configClass = configurable.getConfigClass();
        Cache cache;
        if (classCache.containsKey(configClass)) {
            cache = classCache.get(configClass);
        } else {
            String configClassName = configClass.getName();
            List<String> fields = Stream.of(configClass.getDeclaredFields())
                    .map(Field::getName).collect(Collectors.toList());
            //add cache
            cache = new Cache()
                    .setConfigClassName(configClassName)
                    .setFields(fields);
            classCache.put(configClass, cache);
        }
        String name = null;
        try {
            Method method = accessory.getClass().getMethod("name");
            name = method.invoke(accessory).toString();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return new AccessoryEntity()
                .setConfigClassName(cache.getConfigClassName())
                .setName(name)
                .setConfigFields(cache.getFields());
    }

    @Data
    @Accessors(chain = true)
    private static class Cache {
        private String configClassName;
        private List<String> fields;
    }
}
