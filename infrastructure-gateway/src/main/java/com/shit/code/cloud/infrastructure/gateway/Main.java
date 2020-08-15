package com.shit.code.cloud.infrastructure.gateway;

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
public class Main {
    //        https://www.jianshu.com/p/8f007bcf36ea
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
