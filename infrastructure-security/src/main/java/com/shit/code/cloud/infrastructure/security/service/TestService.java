package com.shit.code.cloud.infrastructure.security.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shit.code.cloud.infrastructure.security.dao.domain.Subject;
import com.shit.code.cloud.infrastructure.security.dao.mapper.SubjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author anthonychen
 * @date 2020/11/2
 */
@Slf4j
@Service
public class TestService extends ServiceImpl<SubjectMapper, Subject> {

}
