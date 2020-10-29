package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.dao.entity.PermissionEntity;
import com.shit.code.cloud.infrastructure.security.service.PermissionService;
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
    PermissionEntity delete(@PathVariable("permissionId") Integer permissionId) {
        return permissionService.delete(permissionId);
    }

    @GetMapping("{permissionId}")
    PermissionEntity find(@PathVariable("permissionId") Integer permissionId) {
        return permissionService.selectOneById(permissionId);
    }

    @PutMapping("")
    PermissionEntity update(@RequestBody PermissionEntity permissionEntity) {
        return permissionService.updateOneById(permissionEntity);
    }

}
