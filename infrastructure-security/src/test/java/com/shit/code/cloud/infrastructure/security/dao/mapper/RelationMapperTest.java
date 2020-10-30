package com.shit.code.cloud.infrastructure.security.dao.mapper;

import com.shit.code.cloud.infrastructure.security.Main;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.Arrays;

@SpringBootTest(classes = Main.class)

@WebAppConfiguration
public class RelationMapperTest extends AbstractTestNGSpringContextTests {

    @Resource
    private RelationMapper relationMapper;

    @Test
    public void test() {
        relationMapper.addPermissions2Role(1, Arrays.asList(1, 2, 3, 4, 5));
    }
}