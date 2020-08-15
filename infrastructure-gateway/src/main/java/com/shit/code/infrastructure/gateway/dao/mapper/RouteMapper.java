package com.shit.code.infrastructure.gateway.dao.mapper;

//import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Anthony Chen
 * @date 2020/7/7
 **/
@Mapper
//@CacheNamespace(implementation = RedisCache.class, flushInterval = 3000)
public interface RouteMapper {
    @Select("select name from `infrastructure-gateway`.test1 where name=#{name}")
    List<String> get(@Param("name") String name);

    @Insert("insert into `infrastructure-gateway`.test1(name) value(#{name})")
    Integer insert(@Param("name") String name);

}
