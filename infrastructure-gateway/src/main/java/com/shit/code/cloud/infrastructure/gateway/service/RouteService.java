package com.shit.code.cloud.infrastructure.gateway.service;



import com.shit.code.cloud.common.entity.BaseEntity;
import com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteAccessoryDTO;
import com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteDTO;
import com.shit.code.cloud.infrastructure.gateway.dao.mapper.RouteAccessoryMapper;
import com.shit.code.cloud.infrastructure.gateway.dao.mapper.RouteMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anthony
 * @date 2020/4/6
 **/
@Service
public class RouteService {
    @Resource
    private RouteMapper routeMapper;

    @Resource
    private RouteAccessoryMapper routeAccessoryMapper;

    /**
     * 查询所有路由
     *
     * @return
     */
    public List<RouteDefinition> allRoutes() {
        return routeMapper.selectList(null).stream()
                .map(RouteDTO::toDefinition).collect(Collectors.toList());
    }

    /**
     * 添加一个路由
     *
     * @param routeDefinition
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(RouteDefinition routeDefinition) {
        RouteDTO routeDTO = RouteDTO.fromDefinition(routeDefinition);
        //插入routeDefinition
        routeMapper.insert(routeDTO);
        List<RouteAccessoryDTO> accessories = new ArrayList<>(
                routeDTO.getFilters().size() + routeDTO.getPredicates().size());
        accessories.addAll(routeDTO.getFilters());
        accessories.addAll(routeDTO.getPredicates());
        //插入filter和predicates
        if (CollectionUtils.isNotEmpty(accessories)) {
            routeAccessoryMapper.insertList(accessories);
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
        routeMapper.updateById(routeDTO);


    }

    /**
     * 删除路由
     *
     * @param routeId 路由id
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(String routeId) {
        routeAccessoryMapper.deleteByRouteId(routeId);
        int count = routeMapper.deleteById(routeId);
        return count > 0;
    }

    /**
     * 更新路由状态
     *
     * @param id
     * @param status
     */
    public void updateStatus(String id, BaseEntity.Status status) {

    }

}
