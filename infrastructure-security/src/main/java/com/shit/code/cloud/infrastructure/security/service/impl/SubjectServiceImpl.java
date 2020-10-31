package com.shit.code.cloud.infrastructure.security.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shit.code.cloud.infrastructure.security.dao.domain.Subject;
import com.shit.code.cloud.infrastructure.security.dao.mapper.SubjectMapper;
import com.shit.code.cloud.mybatis.web.BaseCurdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Service
@Slf4j
public class SubjectServiceImpl implements BaseCurdService<Subject> {

    @Resource
    private SubjectMapper subjectMapper;


    @Override
    public BaseMapper<Subject> getMapper() {
        return subjectMapper;
    }
}
