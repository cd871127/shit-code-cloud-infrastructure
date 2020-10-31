package com.shit.code.cloud.infrastructure.security.service.impl;

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

    /**
     * 插入一条数据
     *
     * @param subjectEntity
     * @return
     */
    public SubjectEntity save(SubjectEntity subjectEntity) {
        int count = subjectMapper.insertOne(subjectEntity);
        if (count != 1) {
            log.warn("插入数据数量异常：{},{}", count, subjectEntity);
        }
        return findById(subjectEntity.getSubjectId());
    }

    /**
     * 删除数据
     *
     * @param subjectId
     * @return
     */
    public SubjectEntity deleteById(final int subjectId) {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setStatus(BaseEntity.Status.DELETED);
        subjectEntity.setSubjectId(subjectId);
        return updateById(subjectEntity);
    }

    public SubjectEntity findById(final int subjectId) {
        return subjectMapper.selectBySubjectId(subjectId);
    }

    public SubjectEntity updateById(SubjectEntity subjectEntity) {
        int count = subjectMapper.updateBySubjectId(subjectEntity);
        if (count != 1) {
            log.warn("更新数据量异常：{},{}", count, subjectEntity.getSubjectId());
        }
        return findById(subjectEntity.getSubjectId());
    }

}
