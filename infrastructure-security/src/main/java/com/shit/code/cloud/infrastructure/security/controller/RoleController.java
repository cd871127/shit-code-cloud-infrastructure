package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.dao.entity.Role;
import com.shit.code.cloud.infrastructure.security.service.RoleServiceImpl;
import com.shit.code.cloud.mybatis.web.BaseCurdController;
import com.shit.code.cloud.mybatis.web.BaseCurdService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@RestController
@RequestMapping("/role")
public class RoleController implements BaseCurdController<Role> {

    @Resource
    private RoleServiceImpl roleService;

    @Override
    public BaseCurdService<Role> getService() {
        return roleService;
    }


}
