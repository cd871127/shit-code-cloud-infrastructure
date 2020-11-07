package com.shit.code.cloud.infrastructure.security.dao.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shit.code.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author Anthony
 * @date 11/1/20
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(schema = "security_db", value = "t_role")
public class Role extends BaseEntity {
    private String roleName;

    private String roleDesc;

    @TableField(exist = false)
    private Set<Permission> permissions;
}
