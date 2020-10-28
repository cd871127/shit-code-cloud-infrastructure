package com.shit.code.cloud.infrastructure.security.service.authentication;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 鉴权服务
 * https://blog.csdn.net/zhangcongyi420/article/details/91348402
 * @author anthonychen
 * @date 2020/10/28
 */
@FeignClient(name = "infrastructure-security")
public interface AuthenticationService {

    String token();
}
