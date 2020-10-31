package com.shit.code.cloud.infrastructure.security.service.impl;

import com.shit.code.cloud.common.entity.BaseEntity;
import com.shit.code.cloud.infrastructure.security.dao.entity.RoleEntity;
import com.shit.code.cloud.infrastructure.security.dao.mapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Service
@Slf4j
public class RoleService {
    @Resource
    private RoleMapper roleMapper;

    public RoleEntity save(RoleEntity roleEntity) {
        int count = roleMapper.insertOne(roleEntity);
        if (count != 1) {
            log.warn("插入数据数量异常：{},{}", count, roleEntity);
        }
        return findById(roleEntity.getRoleId());
    }

    public RoleEntity deleteById(final int roleId) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setStatus(BaseEntity.Status.DELETED);
        roleEntity.setRoleId(roleId);
        return updateById(roleEntity);
    }

    public RoleEntity findById(final int roleId) {
        return roleMapper.selectByRoleId(roleId);
    }

    public RoleEntity updateById(RoleEntity roleEntity) {
        int count = roleMapper.updateByRoleId(roleEntity);
        if (count != 1) {
            log.warn("更新数据量异常：{},{}", count, roleEntity.getRoleId());
        }
        return findById(roleEntity.getRoleId());
    }
}
