package com.shit.code.infrastructure.gateway.dao.mapper;

//import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Anthony Chen
 * @date 2020/7/7
 **/
@Mapper
public interface RouteMapper {

    @Select("select name from `infrastructure-gateway`.test1 where name=#{name}")
    List<String> get(@Param("name") String name);

}
