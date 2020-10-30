package com.shit.code.cloud.infrastructure.security.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Mapper
public interface RelationMapper {

    int addRoles2Subject();

    int addPermissions2Role();

    int removeRolesFromSubject();

    int removePermissionsFromRole();

}
