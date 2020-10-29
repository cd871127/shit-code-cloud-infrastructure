package com.shit.code.cloud.infrastructure.security.dao.mapper;

import com.shit.code.cloud.infrastructure.security.dao.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Mapper
public interface RoleMapper {

    int insertOne(RoleEntity roleEntity);

    int updateByRoleId(RoleEntity roleEntity);

    RoleEntity selectByRoleId(@Param("roleId") Integer roleId);

}
