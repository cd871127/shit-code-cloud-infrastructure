package com.shit.code.cloud.infrastructure.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.factory.HystrixGatewayFilterFactory;

/**
 * @author Anthony Chen
 * @date 2020/7/3
 **/
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class Main {
    //        https://www.jianshu.com/p/8f007bcf36ea
//    https://www.dazhuanlan.com/2019/12/06/5dea2a2471252/
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
