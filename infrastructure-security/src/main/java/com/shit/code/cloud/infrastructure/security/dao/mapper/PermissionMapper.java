package com.shit.code.cloud.infrastructure.security.dao.mapper;

import com.shit.code.cloud.infrastructure.security.dao.entity.PermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Mapper
public interface PermissionMapper {
    int insertOne(PermissionEntity permissionEntity);

    int updateByPermissionId(PermissionEntity permissionEntity);

    PermissionEntity selectByPermissionId(@Param("permissionId") Integer permissionId);
}
