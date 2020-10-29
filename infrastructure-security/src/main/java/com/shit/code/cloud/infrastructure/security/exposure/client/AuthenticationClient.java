package com.shit.code.cloud.infrastructure.security.exposure.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 鉴权服务
 * https://blog.csdn.net/zhangcongyi420/article/details/91348402
 * @author anthonychen
 * @date 2020/10/28
 */
@FeignClient(name = "infrastructure-security",path = "/authentication")
public interface AuthenticationClient {

}
