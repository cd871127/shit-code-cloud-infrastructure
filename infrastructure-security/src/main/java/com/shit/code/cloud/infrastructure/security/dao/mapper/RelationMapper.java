package com.shit.code.cloud.infrastructure.security.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Mapper
public interface RelationMapper {

    int addRoles2Subject(@Param("subjectId") int subjectId, @Param("roleIds") List<Integer> roleIds);

    int addPermissions2Role(@Param("roleId") int roleId, @Param("permissionIds") List<Integer> permissionIds);

    int removeRolesFromSubject();

    int removePermissionsFromRole();

}
