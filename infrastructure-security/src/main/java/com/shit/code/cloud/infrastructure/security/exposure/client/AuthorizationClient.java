package com.shit.code.cloud.infrastructure.security.exposure.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 授权服务
 *
 * @author anthonychen
 * @date 2020/10/28
 */
@FeignClient(name = "infrastructure-security", path = "/authorization")
public interface AuthorizationClient {
}
