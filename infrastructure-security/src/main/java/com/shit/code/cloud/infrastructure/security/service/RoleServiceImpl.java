package com.shit.code.cloud.infrastructure.security.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shit.code.cloud.infrastructure.security.dao.entity.Role;
import com.shit.code.cloud.infrastructure.security.dao.mapper.RoleMapper;
import com.shit.code.cloud.mybatis.web.BaseCurdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 11/1/20
 **/
@Service("roleService")
public class RoleServiceImpl implements BaseCurdService<Role> {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public BaseMapper<Role> getMapper() {
        return roleMapper;
    }
}
