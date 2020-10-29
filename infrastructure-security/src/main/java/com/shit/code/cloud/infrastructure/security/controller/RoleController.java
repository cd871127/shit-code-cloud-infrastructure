package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.common.entity.BaseEntity;
import com.shit.code.cloud.infrastructure.security.dao.entity.RoleEntity;
import com.shit.code.cloud.infrastructure.security.dao.entity.RoleEntity;
import com.shit.code.cloud.infrastructure.security.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @PostMapping("")
    RoleEntity save(@RequestBody RoleEntity roleEntity) {
        return roleService.save(roleEntity);
    }

    @DeleteMapping("{roleId}")
    RoleEntity delete(@PathVariable("roleId") Integer roleId) {
        return roleService.delete(roleId);
    }

    @GetMapping("{roleId}")
    RoleEntity find(@PathVariable("roleId") Integer roleId) {
        return roleService.selectOneById(roleId);
    }

    @PutMapping("")
    RoleEntity update(@RequestBody RoleEntity roleEntity) {
        return roleService.updateOneById(roleEntity);
    }

}
