package com.shit.code.cloud.infrastructure.gateway.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteAccessoryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
//@CacheNamespace(implementation= RedisCache.class)
public interface RouteAccessoryMapper extends BaseMapper<RouteAccessoryDTO> {

//    List<RouteAccessoryDTO> selectList(RouteAccessoryDTO routeAccessoryDTO);
//
//    int insert(RouteAccessoryDTO routeAccessoryDTO);
//
//    int insertList(List<RouteAccessoryDTO> routeAccessoryDTO);
//
//    @Delete("delete from gateway_db.t_route_accessory where route_id=#{routeId}")
//    int deleteByRouteId(@Param("routeId") String routeId);
}
