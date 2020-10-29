package com.shit.code.cloud.infrastructure.security.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.BearerToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * jwt认证
 *
 * @author Anthony
 * @date 10/29/20
 **/
@Component
@Order(1)
public class JwtAuthenticationRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (!(token instanceof BearerToken)) {
            return null;
        }
        return null;
    }
}
