package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.dao.domain.Subject;
import com.shit.code.cloud.infrastructure.security.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@RequestMapping("/subject")
@RestController
@Slf4j
public class SubjectController {

    //    @Resource
//    private SubjectServiceImpl subjectService;
//
//
//    @Override
//    public BaseCurdService<Subject> getService() {
//        return subjectService;
//    }
    @Resource
    private TestService testService;

    @GetMapping("test")
    public String test() {
        Subject subject = new Subject();
        subject.setPassword("123");
        testService.save(subject);
        log.info("{}", subject);
        return "123";
    }

}
