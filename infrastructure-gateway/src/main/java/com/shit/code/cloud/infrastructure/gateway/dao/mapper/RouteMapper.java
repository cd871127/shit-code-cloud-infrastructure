package com.shit.code.cloud.infrastructure.gateway.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author anthony
 */
@Mapper
//@CacheNamespace(implementation= RedisCache.class)
public interface RouteMapper extends BaseMapper<RouteDTO> {

//    int insert(RouteDTO routeDTO);
//
//    int updateById(RouteDTO routeDTO);
//
//    /**
//     * 查询单个记录
//     *
//     * @param routeDTO
//     * @return
//     */
//    RouteDTO selectOne(RouteDTO routeDTO);
//
//    /**
//     * 查询多个记录
//     *
//     * @param routeDTO
//     * @return
//     */
//    List<RouteDTO> selectList(RouteDTO routeDTO);
//
//    @Delete("delete from gateway_db.t_route where id=#{id}")
//    int deleteById(@Param("id") String id);
}
