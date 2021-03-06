package com.shit.code.cloud.infrastructure.security.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shit.code.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Anthony
 * @date 11/1/20
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(schema = "security_db", value = "t_subject_role_rel")
public class SubjectRoleRel extends BaseEntity {

    private Integer subjectId;

    private Integer roleId;
}
