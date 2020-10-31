package com.shit.code.cloud.infrastructure.security.service;

import com.shit.code.cloud.infrastructure.security.dao.domain.Role;
import com.shit.code.cloud.infrastructure.security.dao.domain.Subject;
import com.shit.code.cloud.infrastructure.security.dao.mapper.RolePermissionRelMapper;
import com.shit.code.cloud.infrastructure.security.dao.mapper.SubjectRoleRelMapper;
import com.shit.code.cloud.infrastructure.security.service.impl.PermissionServiceImpl;
import com.shit.code.cloud.infrastructure.security.service.impl.RoleServiceImpl;
import com.shit.code.cloud.infrastructure.security.service.impl.SubjectServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Anthony
 * @date 11/1/20
 **/
@Service
public class RelationService {

    @Resource
    private PermissionServiceImpl permissionService;

    @Resource
    private RoleServiceImpl roleService;

    @Resource
    private SubjectServiceImpl subjectService;

    @Resource
    private SubjectRoleRelMapper subjectRoleRelMapper;

    @Resource
    private RolePermissionRelMapper rolePermissionRelMapper;


    public Role addPermissions2Role(final int roleId, List<Integer> permissionIds) {
        return null;
    }

    public Subject addRoles2Subject(final int subjectId, List<Integer> roleIds) {
        return null;
    }
}
