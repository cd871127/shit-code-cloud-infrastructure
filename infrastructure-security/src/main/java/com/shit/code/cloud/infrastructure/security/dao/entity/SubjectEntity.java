package com.shit.code.cloud.infrastructure.security.dao.entity;

import com.shit.code.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SubjectEntity extends BaseEntity {

    private Integer subjectId;

    private String password;

    private String fingerprint;

    private String faceIdentification;

}
