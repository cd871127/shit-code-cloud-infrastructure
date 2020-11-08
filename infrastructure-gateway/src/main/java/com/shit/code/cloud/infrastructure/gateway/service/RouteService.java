package com.shit.code.cloud.infrastructure.gateway.service;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.shit.code.cloud.infrastructure.gateway.dao.RouteAccessoryDAO;
import com.shit.code.cloud.infrastructure.gateway.dao.RouteDAO;
import com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteAccessoryDTO;
import com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteDTO;
import com.shit.code.mybatis.entity.BaseEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteAccessoryDTO.AccessoryType.FILTER;
import static com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteAccessoryDTO.AccessoryType.PREDICATE;

/**
 * @author Anthony
 * @date 2020/4/6
 **/
@Service
public class RouteService {
    @Resource
    private RouteDAO routeDAO;

    @Resource
    private RouteAccessoryDAO routeAccessoryDAO;

    /**
     * 查询所有路由
     *
     * @return
     */
    @Cacheable(key = "'route_cache_key'", cacheNames = "route_cache", cacheManager = "shitCodeCacheManager")
    public List<RouteDefinition> allRoutes() {
        return routeDAO.list().stream().peek(
                routeDTO -> {
                    List<RouteAccessoryDTO> accessories = routeAccessoryDAO
                            .list(Wrappers.lambdaQuery(RouteAccessoryDTO.class).eq(RouteAccessoryDTO::getRouteId, routeDTO.getRouteId()));
                    Map<RouteAccessoryDTO.AccessoryType, List<RouteAccessoryDTO>> accessoriesMap = accessories
                            .stream().collect(Collectors.groupingBy(RouteAccessoryDTO::getType));
                    if (accessoriesMap.containsKey(PREDICATE)) {
                        routeDTO.setPredicates(accessoriesMap.get(PREDICATE));
                    }
                    if (accessoriesMap.containsKey(FILTER)) {
                        routeDTO.setFilters(accessoriesMap.get(FILTER));
                    }
                }
        ).map(RouteDTO::toDefinition).collect(Collectors.toList());
    }

    /**
     * 添加一个路由
     *
     * @param routeDefinition
     */
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(key = "'route_cache_key'", cacheNames = "route_cache", cacheManager = "shitCodeCacheManager")
    public void add(RouteDefinition routeDefinition) {
        RouteDTO routeDTO = RouteDTO.fromDefinition(routeDefinition);
        //插入routeDefinition,如果routeid有重复, 这里就会异常
        routeDAO.save(routeDTO);
        List<RouteAccessoryDTO> accessories = new ArrayList<>(
                routeDTO.getFilters().size() + routeDTO.getPredicates().size());
        accessories.addAll(routeDTO.getFilters());
        accessories.addAll(routeDTO.getPredicates());
        //插入filter和predicates
        if (CollectionUtils.isNotEmpty(accessories)) {
            routeAccessoryDAO.saveBatch(accessories);
        }
    }

    /**
     * 更新路由
     *
     * @param routeDefinition
     */
    @Transactional(rollbackFor = Exception.class)
    public void update(RouteDefinition routeDefinition) {
        RouteDTO routeDTO = RouteDTO.fromDefinition(routeDefinition);
        RouteDTO tmp = routeDAO.getOne(routeDAO.lambdaQuery().eq(RouteDTO::getRouteId, routeDTO.getRouteId()));
        if (tmp != null) {
            routeDTO.setRouteId(tmp.getRouteId());
            routeDAO.updateById(routeDTO);
        }
        //TODO 抛出异常
    }

    /**
     * 删除路由
     *
     * @param routeId 路由id
     */
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(key = "'route_cache_key'", cacheNames = "route_cache", cacheManager = "shitCodeCacheManager")
    public boolean delete(String routeId) {
        routeAccessoryDAO.remove(Wrappers.lambdaQuery(RouteAccessoryDTO.class).eq(RouteAccessoryDTO::getRouteId, routeId));
        routeDAO.remove(Wrappers.lambdaQuery(RouteDTO.class).eq(RouteDTO::getRouteId, routeId));
        return true;
    }

    /**
     * 更新路由状态
     *
     * @param id
     * @param status
     */
    public void updateStatus(String id, BaseEntity.DataStatus status) {

    }

}
