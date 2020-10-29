package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.security.service.RelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Slf4j
@RestController("/relation")
public class RelationController {

    @Resource
    private RelationService relationService;


}
