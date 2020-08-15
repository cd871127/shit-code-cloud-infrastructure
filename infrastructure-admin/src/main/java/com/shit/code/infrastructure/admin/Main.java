package com.shit.code.infrastructure.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Anthony Chen
 * @date 2020/7/3
 **/
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class Main {
    public static void main(String[] args) {
//https://codecentric.github.io/spring-boot-admin/2.2.3/#getting-started
        SpringApplication.run(Main.class, args);
    }

}
