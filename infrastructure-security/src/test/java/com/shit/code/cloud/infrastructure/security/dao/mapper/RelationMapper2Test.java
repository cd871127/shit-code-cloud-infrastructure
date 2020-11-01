package com.shit.code.cloud.infrastructure.security.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.shit.code.cloud.infrastructure.security.dao.domain.RolePermissionRel;
import com.shit.code.cloud.infrastructure.security.service.impl.TestServiceImpl;
import com.shit.code.cloud.mybatis.entity.BaseEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.shit.code.cloud.mybatis.entity.BaseEntity.DataStatus.VALID;

@ActiveProfiles("cluster")
@SpringBootTest
@RunWith(SpringRunner.class)
public class RelationMapper2Test {

    @Resource
    private RolePermissionRelMapper rolePermissionRelMapper;

    @Resource
    TestServiceImpl testService;

    @Test
    public void test() {
        rolePermissionRelMapper.addPermissions2Role(1, Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    public void test2() {
        RolePermissionRel rolePermissionRel = new RolePermissionRel();
        rolePermissionRel.setPermissionId(100);
        rolePermissionRel.setRoleId(100);
        UpdateWrapper<RolePermissionRel> wrapper = new UpdateWrapper<>();
        testService.saveOrUpdate(rolePermissionRel, wrapper);
    }

    @Test
    public void test3() {
        List a = testService.lambdaQuery().eq(true, BaseEntity::getDataStatus, VALID).list();
        System.out.println(a);
    }
}