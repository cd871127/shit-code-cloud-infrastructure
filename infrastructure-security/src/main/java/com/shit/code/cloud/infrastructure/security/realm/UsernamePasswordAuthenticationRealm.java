package com.shit.code.cloud.infrastructure.security.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 用户名密码认证
 *
 * @author Anthony
 * @date 10/29/20
 **/
@Component
@Order(0)
public class UsernamePasswordAuthenticationRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }
}
