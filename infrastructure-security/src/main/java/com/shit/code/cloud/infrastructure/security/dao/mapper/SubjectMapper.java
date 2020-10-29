package com.shit.code.cloud.infrastructure.security.dao.mapper;

import com.shit.code.cloud.infrastructure.security.dao.entity.SubjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Mapper
public interface SubjectMapper {

    int insertOne(SubjectEntity subjectEntity);

    int updateBySubjectId(SubjectEntity subjectEntity);

    SubjectEntity selectBySubjectId(@Param("subjectId") Integer subjectId);
}
