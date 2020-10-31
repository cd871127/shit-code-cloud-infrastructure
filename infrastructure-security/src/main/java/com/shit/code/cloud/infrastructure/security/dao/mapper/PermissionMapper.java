package com.shit.code.cloud.infrastructure.security.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shit.code.cloud.infrastructure.security.dao.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
