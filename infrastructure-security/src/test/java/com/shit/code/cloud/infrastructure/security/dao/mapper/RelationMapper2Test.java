package com.shit.code.cloud.infrastructure.security.dao.mapper;

import com.shit.code.cloud.mybatis.log.SqlLogInterceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;

@ActiveProfiles("cluster")
@SpringBootTest
@RunWith(SpringRunner.class)
public class RelationMapper2Test {

    @Resource
    private RelationMapper relationMapper;

    @Resource
    private RoleMapper roleMapper;
    @Test
    public void addPermissions2Role() {
        relationMapper.addPermissions2Role(1, Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    public void addRoles2Subject() {
        relationMapper.addRoles2Subject(1, Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    public void selectByRoleId(){
        roleMapper.selectByRoleId(1);
    }
}