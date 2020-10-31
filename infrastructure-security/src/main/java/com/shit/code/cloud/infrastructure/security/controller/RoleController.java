package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.dao.entity.RoleEntity;
import com.shit.code.cloud.infrastructure.security.service.impl.RoleService;
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
    RoleEntity deleteById(@PathVariable("roleId") Integer roleId) {
        return roleService.deleteById(roleId);
    }

    @GetMapping("{roleId}")
    RoleEntity findById(@PathVariable("roleId") Integer roleId) {
        return roleService.findById(roleId);
    }

    @PutMapping("{roleId}")
    RoleEntity updateById(@PathVariable("roleId") Integer roleId, @RequestBody RoleEntity roleEntity) {
        roleEntity.setRoleId(roleId);
        return roleService.updateById(roleEntity);
    }

}
