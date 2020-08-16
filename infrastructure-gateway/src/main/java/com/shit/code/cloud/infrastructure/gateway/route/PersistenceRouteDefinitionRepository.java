package com.shit.code.cloud.infrastructure.gateway.route;

import com.shit.code.cloud.infrastructure.gateway.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * @author Anthony Chen
 * @date 2020/7/6
 **/
@Slf4j
@Component
public class PersistenceRouteDefinitionRepository implements RouteDefinitionRepository {

    @Resource
    private RouteService routeService;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        log.info("查询2");
        return Flux.fromIterable(Collections.emptyList());
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        log.info("保存2");
        return route.flatMap(r -> {
            if (StringUtils.isEmpty(r.getId())) {
                return Mono.error(new IllegalArgumentException("id may not be empty"));
            }
            routeService.add(r);
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        log.info("删除2");
        return Mono.empty();
//        return routeId.flatMap(id -> {
//            if (routes.containsKey(id)) {
//                routes.remove(id);
//                return Mono.empty();
//            }
//            //发mq
//            return Mono.defer(() -> Mono.error(
//                    new NotFoundException("RouteDefinition not found: " + routeId)));
//        });
    }
}
