package com.shit.code.cloud.infrastructure.gateway.dao.mapper;

import com.shit.code.cloud.infrastructure.gateway.dao.dto.RouteAccessoryDTO;
import com.shit.code.cloud.mybatis.cache.RedisCache;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
@CacheNamespace(implementation= RedisCache.class)
public interface RouteAccessoryMapper {

    List<RouteAccessoryDTO> selectList(RouteAccessoryDTO routeAccessoryDTO);

    int insert(RouteAccessoryDTO routeAccessoryDTO);

    int insertList(List<RouteAccessoryDTO> routeAccessoryDTO);

    @Delete("delete from gateway_db.t_route_accessory where route_id=#{routeId}")
    int deleteByRouteId(@Param("routeId") String routeId);
}
