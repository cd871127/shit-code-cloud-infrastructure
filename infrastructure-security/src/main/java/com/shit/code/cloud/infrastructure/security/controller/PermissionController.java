package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.dao.entity.Permission;
import com.shit.code.cloud.infrastructure.security.service.PermissionServiceImpl;
import com.shit.code.cloud.mybatis.web.BaseCurdController;
import com.shit.code.cloud.mybatis.web.BaseCurdService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 11/1/20
 **/
@RestController
@RequestMapping("/permission")
public class PermissionController implements BaseCurdController<Permission> {

    @Resource
    private PermissionServiceImpl permissionService;

    @Override
    public BaseCurdService<Permission> getService() {
        return permissionService;
    }
}
