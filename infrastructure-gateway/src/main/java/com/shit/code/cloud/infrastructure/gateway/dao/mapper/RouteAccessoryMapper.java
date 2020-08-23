package com.shit.code.cloud.infrastructure.gateway.dao.mapper;

import com.shit.code.cloud.infrastructure.gateway.dao.dto.RouteAccessoryDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RouteAccessoryMapper {

    List<RouteAccessoryDTO> selectList(RouteAccessoryDTO routeAccessoryDTO);

    int insert(RouteAccessoryDTO routeAccessoryDTO);

    int insertList(List<RouteAccessoryDTO> routeAccessoryDTO);

    @Delete("delete from gateway_db.t_route_accessory where route_id=#{routeId}")
    int deleteByRouteId(@Param("routeId") String routeId);
}
