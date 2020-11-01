package com.shit.code.cloud.infrastructure.security.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shit.code.cloud.infrastructure.security.dao.domain.RolePermissionRel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Anthony
 * @date 11/1/20
 **/
@Mapper
public interface RolePermissionRelMapper extends BaseMapper<RolePermissionRel> {
    int addRoles2Subject(@Param("subjectId") int subjectId, @Param("roleIds") List<Integer> roleIds);

    int addPermissions2Role(@Param("roleId") int roleId, @Param("permissionIds") List<Integer> permissionIds);
}
