package com.shit.code.cloud.infrastructure.gateway.route;

import org.junit.Test;
import org.springframework.cloud.gateway.filter.FilterDefinition;

public class PersistenceRouteDefinitionRepositoryTest {
    @Test
    public void test() {
        FilterDefinition filterDefinition=new FilterDefinition("test=1,2,3,4");
        System.out.println(1);

//        new Predi("test=1,2,3,4");
    }

}