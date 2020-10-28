package com.shit.code.cloud.infrastructure.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author anthonychen
 * @date 2020/10/14
 **/
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
//@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
