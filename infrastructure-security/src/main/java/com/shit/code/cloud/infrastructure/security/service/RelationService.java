package com.shit.code.cloud.infrastructure.security.service;

import com.shit.code.cloud.infrastructure.security.dao.mapper.RelationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Service
@Slf4j
public class RelationService {
    @Resource
    private SubjectService subjectService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    @Resource
    private RelationMapper relationMapper;


}
