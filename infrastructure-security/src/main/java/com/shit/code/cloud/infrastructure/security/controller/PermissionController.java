package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.dao.entity.PermissionEntity;
import com.shit.code.cloud.infrastructure.security.service.impl.PermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @PostMapping("")
    PermissionEntity save(@RequestBody PermissionEntity permissionEntity) {
        return permissionService.save(permissionEntity);
    }

    @DeleteMapping("{permissionId}")
    PermissionEntity deleteById(@PathVariable("permissionId") Integer permissionId) {
        return permissionService.deleteById(permissionId);
    }

    @GetMapping("{permissionId}")
    PermissionEntity findById(@PathVariable("permissionId") Integer permissionId) {
        return permissionService.findById(permissionId);
    }

    @PutMapping("{permissionId}")
    PermissionEntity updateById(@PathVariable("permissionId") Integer permissionId, @RequestBody PermissionEntity permissionEntity) {
        permissionEntity.setPermissionId(permissionId);
        return permissionService.updateById(permissionEntity);
    }

}
