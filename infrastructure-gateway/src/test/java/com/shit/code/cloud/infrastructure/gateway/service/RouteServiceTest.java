package com.shit.code.cloud.infrastructure.gateway.service;

import org.junit.Test;
import org.springframework.cloud.gateway.route.RouteDefinition;


public class RouteServiceTest {
    @Test
    public void test() {
        System.out.println(1);
//        String definition = "RouteDefinition{id='ReactiveCompositeDiscoveryClient_service-admin', predicates=[PredicateDefinition{name='Path', args={pattern=/service-admin/**}}], filters=[FilterDefinition{name='RewritePath', args={regexp=/service-admin/(?<remaining>.*), replacement=/${remaining}}}], uri=lb://service-admin, order=0, metadata={}}";
        String definition = "route001=http://127.0.0.1,Host=**.addrequestparameter.org,Path=/get";
        RouteDefinition routeDefinition = new RouteDefinition(definition);
        System.out.println(1);
    }

}