package com.shit.code.cloud.infrastructure.gateway.service;

import com.shit.code.cloud.infrastructure.gateway.dao.RouteDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@ActiveProfiles("dev")
@SpringBootTest
@RunWith(SpringRunner.class)
public class RouteServiceTest {
    @Resource
    private RouteDAO routeDAO;

    @Test
    public void test() {
        routeDAO.list();
    }

}