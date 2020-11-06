package com.shit.code.cloud.infrastructure.gateway.controller;

import com.shit.code.cloud.infrastructure.gateway.entity.AccessoryEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory;
import org.springframework.cloud.gateway.support.Configurable;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author anthony
 */
@Slf4j
@RestController
@RequestMapping("/route")

public class RouteController {

    @Resource
    private List<GatewayFilterFactory<?>> gatewayFilters;

    @Resource
    private List<RoutePredicateFactory<?>> routePredicates;

    private static final ConcurrentHashMap<Class<?>, Cache> CLASS_CACHE = new ConcurrentHashMap<>(32);


    /**
     * 查询可用filter列表
     *
     * @return
     */
    @GetMapping("filters")
    @Cacheable
    public List<AccessoryEntity> filters() {
        log.info("======================================");
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
    public List<AccessoryEntity> predicates() {
        return routePredicates.stream().map(this::extractAccessoryInfo)
                .collect(Collectors.toList());
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
        if (CLASS_CACHE.containsKey(configClass)) {
            cache = CLASS_CACHE.get(configClass);
        } else {
            String configClassName = configClass.getName();
            List<String> fields = Stream.of(configClass.getDeclaredFields())
                    .map(Field::getName).collect(Collectors.toList());
            //add cache
            cache = new Cache()
                    .setConfigClassName(configClassName)
                    .setFields(fields);
            CLASS_CACHE.put(configClass, cache);
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

    @GetMapping(value = "stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> test() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        return Flux.interval(Duration.ofSeconds(1)).map(l -> atomicInteger.addAndGet(1))
                .log();
    }
}
