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
@TableName(schema = "security_db", value = "t_role_permission_rel")
public class RolePermissionRel extends BaseEntity {

    private Integer roleId;

    private Integer permissionId;
}
