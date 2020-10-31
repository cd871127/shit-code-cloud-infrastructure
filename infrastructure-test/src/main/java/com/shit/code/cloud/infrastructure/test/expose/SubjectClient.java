package com.shit.code.cloud.infrastructure.test.expose;

import com.shit.code.cloud.infrastructure.test.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author anthonychen
 * @date 2020/10/15
 **/
@FeignClient(name = "infrastructure-security", path = "/subject")
public interface SubjectClient {
    @GetMapping("{subjectId}")
    Subject findById(@PathVariable("subjectId") Integer subjectId);

    @GetMapping("{subjectId}")
    Object findById2(@PathVariable("subjectId") Integer subjectId);
}
