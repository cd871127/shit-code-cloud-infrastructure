package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.dao.entity.Subject;
import com.shit.code.cloud.infrastructure.security.service.SubjectServiceImpl;
import com.shit.code.cloud.mybatis.web.BaseCurdController;
import com.shit.code.cloud.mybatis.web.BaseCurdService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@RequestMapping("/subject")
@RestController
public class SubjectController implements BaseCurdController<Subject> {

    @Resource
    private SubjectServiceImpl subjectService;


    @Override
    public BaseCurdService<Subject> getService() {
        return subjectService;
    }
}
