package com.shit.code.cloud.infrastructure.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Anthony
 * @date 10/4/20
 **/
@Slf4j
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)

@EnableDiscoveryClient
@EnableCaching
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
