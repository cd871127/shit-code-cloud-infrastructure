package com.shit.code.cloud.infrastructure.gateway.route;

import com.shit.code.cloud.infrastructure.gateway.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

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
        return Flux.fromIterable(routeService.allRoutes());
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        log.debug("添加路由：{}", route);
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
        return routeId.flatMap(id -> {
            log.debug("删除路由：{}", id);
            if (routeService.delete(id)) {
                return Mono.empty();
            }
            return Mono.defer(() -> Mono.error(
                    new NotFoundException("RouteDefinition not found: " + routeId)));
        });
    }
}
