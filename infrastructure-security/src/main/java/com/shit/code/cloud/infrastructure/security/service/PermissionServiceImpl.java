package com.shit.code.cloud.infrastructure.security.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shit.code.cloud.infrastructure.security.dao.entity.Permission;
import com.shit.code.cloud.infrastructure.security.dao.mapper.PermissionMapper;
import com.shit.code.cloud.mybatis.web.BaseCurdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 11/1/20
 **/
@Service("permissionService")
public class PermissionServiceImpl implements BaseCurdService<Permission> {
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public BaseMapper<Permission> getMapper() {
        return permissionMapper;
    }
}
