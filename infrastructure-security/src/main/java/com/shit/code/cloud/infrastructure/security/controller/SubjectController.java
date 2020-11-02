package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.dao.domain.Subject;
import com.shit.code.cloud.infrastructure.security.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="测试类tagname",description = "测试类tagdesc")
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
    @Operation(method = "GET",description = "测试oper")
    public String test() {
        Subject subject = new Subject();
        subject.setPassword("123");
        testService.save(subject);
        log.info("{}", subject);
        return "123";
    }

}
