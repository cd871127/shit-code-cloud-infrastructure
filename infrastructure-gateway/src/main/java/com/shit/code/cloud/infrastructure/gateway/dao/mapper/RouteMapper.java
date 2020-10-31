package com.shit.code.cloud.infrastructure.gateway.dao.mapper;

import com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteDTO;
import com.shit.code.cloud.mybatis.cache.RedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author anthony
 */
@Mapper
@CacheNamespace(implementation= RedisCache.class)
public interface RouteMapper {

    int insert(RouteDTO routeDTO);

    int updateById(RouteDTO routeDTO);

    /**
     * 查询单个记录
     *
     * @param routeDTO
     * @return
     */
    RouteDTO selectOne(RouteDTO routeDTO);

    /**
     * 查询多个记录
     *
     * @param routeDTO
     * @return
     */
    List<RouteDTO> selectList(RouteDTO routeDTO);

    @Delete("delete from gateway_db.t_route where id=#{id}")
    int deleteById(@Param("id") String id);
}
