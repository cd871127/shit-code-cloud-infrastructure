package com.shit.code.cloud.infrastructure.security.service;

import com.shit.code.cloud.common.entity.BaseEntity;
import com.shit.code.cloud.infrastructure.security.dao.entity.PermissionEntity;
import com.shit.code.cloud.infrastructure.security.dao.mapper.PermissionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Service
@Slf4j
public class PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 保存permission
     *
     * @param permissionEntity
     * @return
     */
    public PermissionEntity save(PermissionEntity permissionEntity) {
        int count = permissionMapper.insertOne(permissionEntity);
        if (count != 1) {
            log.warn("插入数据数量异常：{},{}", count, permissionEntity);
        }
        return selectOneById(permissionEntity.getPermissionId());
    }

    /**
     * 删除permission
     *
     * @param permissionId
     * @return
     */
    public PermissionEntity delete(final int permissionId) {
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.setStatus(BaseEntity.Status.INVALID);
        permissionEntity.setPermissionId(permissionId);
        return updateOneById(permissionEntity);
    }

    public PermissionEntity selectOneById(final int permissionId) {
        return permissionMapper.selectByPermissionId(permissionId);
    }

    public PermissionEntity updateOneById(PermissionEntity permissionEntity) {
        int count = permissionMapper.updateByPermissionId(permissionEntity);
        if (count != 1) {
            log.warn("更新数据量异常：{},{}", count, permissionEntity.getPermissionId());
        }
        return selectOneById(permissionEntity.getPermissionId());
    }
}
