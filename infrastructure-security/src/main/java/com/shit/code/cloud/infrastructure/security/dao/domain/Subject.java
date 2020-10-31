package com.shit.code.cloud.infrastructure.security.dao.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shit.code.cloud.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(schema = "security_db", value = "t_subject")
public class Subject extends BaseEntity {
    private String password;

    private String fingerprint;

    private String faceIdentification;

    @TableField(exist = false)
    private Set<Role> roles;
}
