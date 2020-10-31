package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.dao.entity.SubjectEntity;
import com.shit.code.cloud.infrastructure.security.service.impl.SubjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    @PostMapping("")
    SubjectEntity save(@RequestBody SubjectEntity subjectEntity) {
        return subjectService.save(subjectEntity);
    }

    @DeleteMapping("{subjectId}")
    SubjectEntity deleteById(@PathVariable("subjectId") Integer subjectId) {
        return subjectService.deleteById(subjectId);
    }

    @GetMapping("{subjectId}")
    SubjectEntity findById(@PathVariable("subjectId") Integer subjectId) {
        return subjectService.findById(subjectId);
    }

    @PutMapping("{subjectId}")
    SubjectEntity updateById(@PathVariable("subjectId") Integer subjectId, @RequestBody SubjectEntity subjectEntity) {
        subjectEntity.setSubjectId(subjectId);
        return subjectService.updateById(subjectEntity);
    }
}
