package com.shit.code.cloud.infrastructure.security.service.authorization;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 授权服务
 *
 * @author anthonychen
 * @date 2020/10/28
 */
@FeignClient(name = "infrastructure-security")
public interface AuthorizationService {
}
