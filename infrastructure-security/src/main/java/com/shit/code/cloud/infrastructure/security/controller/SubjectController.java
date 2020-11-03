package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.dao.domain.Subject;
import com.shit.code.cloud.infrastructure.security.service.TestService;
import com.shit.code.cloud.log.LogLevel;
import com.shit.code.cloud.log.annotation.AroundLog;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.EndpointId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@Tag(name = "测试类tagname", description = "测试类tagdesc")
public class SubjectController {
    @Value("${test:999}")
    private Integer olal;
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

    @GetMapping("test/{password}")
    @Operation(method = "GET", description = "测试oper")
    @AroundLog(level = LogLevel.INFO)
    public Integer test(@PathVariable("password") String password) {
        Subject subject = new Subject();
        subject.setPassword("123");
        testService.save(subject);
        log.info("{}", subject);
        return olal;
    }

}
