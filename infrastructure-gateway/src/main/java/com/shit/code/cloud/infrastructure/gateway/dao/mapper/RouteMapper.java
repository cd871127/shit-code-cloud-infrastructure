package com.shit.code.cloud.infrastructure.gateway.dao.mapper;

import com.shit.code.cloud.common.dto.BaseDTO;
import com.shit.code.cloud.infrastructure.gateway.dao.dto.RouteDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RouteMapper {

    int insert(RouteDTO routeDTO);

    int updateById(RouteDTO routeDTO);

    RouteDTO selectOne(@Param("id") String id, @Param("status") BaseDTO.Status status, @Param("uniqueId") String uniqueId);

    List<RouteDTO> selectList(@Param("status") BaseDTO.Status status);

}
