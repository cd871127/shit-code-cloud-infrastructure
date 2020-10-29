package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.dao.entity.SubjectEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @PostMapping("")
    SubjectEntity save(@RequestBody SubjectEntity subjectEntity) {
        System.out.println(subjectEntity);
        return null;
    }

    @DeleteMapping("{subjectId}")
    SubjectEntity delete(@PathVariable("subjectId") Integer subjectId) {
        SubjectEntity subjectEntity = find(subjectId);
        //TODO delete
        return subjectEntity;
    }

    @GetMapping("{subjectId}")
    SubjectEntity find(@PathVariable("subjectId") Integer subjectId) {
        return null;
    }

    @PutMapping("{subjectId}")
    SubjectEntity update(@PathVariable("subjectId") Integer subjectId, @RequestBody SubjectEntity subjectEntity) {


        SubjectEntity newEntity = find(subjectId);
        return subjectEntity;
    }
}
