package com.shit.code.cloud.infrastructure.security.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author anthonychen
 * @date 2020/10/15
 **/
@FeignClient(name = "infrastructure-test")
public interface TestService extends TestFeignClient {

}
