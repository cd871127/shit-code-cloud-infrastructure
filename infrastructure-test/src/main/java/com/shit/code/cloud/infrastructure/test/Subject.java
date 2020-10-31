package com.shit.code.cloud.infrastructure.test;

import lombok.Data;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Data

public class Subject {
    private String password;

    private String fingerprint;

    private String faceIdentification;

//    @TableField(exist = false)
//    private Set<RoleEntity> roles;
}
