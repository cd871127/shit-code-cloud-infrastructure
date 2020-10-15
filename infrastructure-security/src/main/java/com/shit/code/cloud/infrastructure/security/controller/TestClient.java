package com.shit.code.cloud.infrastructure.security.controller;

import com.shit.code.cloud.infrastructure.test.expose.TestFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author anthonychen
 * @date 2020/10/15
 **/
@FeignClient(
        name = "infrastructure-test"
)
public interface TestClient extends TestFeignClient {
}
