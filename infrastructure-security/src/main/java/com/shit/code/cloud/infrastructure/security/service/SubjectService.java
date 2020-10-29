package com.shit.code.cloud.infrastructure.security.service;

import com.shit.code.cloud.common.entity.BaseEntity;
import com.shit.code.cloud.infrastructure.security.dao.entity.SubjectEntity;
import com.shit.code.cloud.infrastructure.security.dao.mapper.SubjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Service
@Slf4j
public class SubjectService {

    @Resource
    private SubjectMapper subjectMapper;

    public SubjectEntity save(SubjectEntity subjectEntity) {
        int count = subjectMapper.insertOne(subjectEntity);
        if (count != 1) {
            log.warn("插入数据数量异常：{},{}", count, subjectEntity);
        }
        return selectOneById(subjectEntity.getSubjectId());
    }

    public SubjectEntity delete(final int subjectId) {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setStatus(BaseEntity.Status.INVALID);
        subjectEntity.setSubjectId(subjectId);
        return updateOneById(subjectEntity);
    }

    public SubjectEntity selectOneById(final int subjectId) {
        return subjectMapper.selectBySubjectId(subjectId);
    }

    public SubjectEntity updateOneById(SubjectEntity subjectEntity) {
        int count = subjectMapper.updateBySubjectId(subjectEntity);
        if (count != 1) {
            log.warn("更新数据量异常：{},{}", count, subjectEntity.getSubjectId());
        }
        return selectOneById(subjectEntity.getSubjectId());
    }
}
