package com.shit.code.cloud.infrastructure.gateway.service;


import com.shit.code.cloud.common.dto.BaseDTO;
import com.shit.code.cloud.infrastructure.gateway.dao.dto.RouteAccessoryDTO;
import com.shit.code.cloud.infrastructure.gateway.dao.dto.RouteDTO;
import com.shit.code.cloud.infrastructure.gateway.dao.mapper.RouteAccessoryMapper;
import com.shit.code.cloud.infrastructure.gateway.dao.mapper.RouteMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
     * @param id 路由id
     */
    public void delete(String id) {

    }

    /**
     * 更新路由状态
     *
     * @param id
     * @param status
     */
    public void updateStatus(String id, BaseDTO.Status status) {

    }

}
