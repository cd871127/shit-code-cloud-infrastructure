package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.common.entity.BaseEntity;
import com.shit.code.cloud.infrastructure.security.dao.entity.SubjectEntity;
import com.shit.code.cloud.infrastructure.security.service.SubjectService;
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
        subjectEntity.setStatus(BaseEntity.Status.VALID);
        return subjectService.save(subjectEntity);
    }

    @DeleteMapping("{subjectId}")
    SubjectEntity delete(@PathVariable("subjectId") Integer subjectId) {
        return subjectService.delete(subjectId);
    }

    @GetMapping("{subjectId}")
    SubjectEntity find(@PathVariable("subjectId") Integer subjectId) {
        return subjectService.selectOneById(subjectId);
    }

    @PutMapping("{subjectId}")
    SubjectEntity update(@PathVariable("subjectId") Integer subjectId, @RequestBody SubjectEntity subjectEntity) {
        SubjectEntity newEntity = find(subjectId);
        return subjectEntity;
    }
}
