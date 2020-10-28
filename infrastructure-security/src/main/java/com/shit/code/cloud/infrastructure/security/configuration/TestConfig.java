package com.shit.code.cloud.infrastructure.security.configuration;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个bean覆盖org.apache.shiro.spring.boot.autoconfigure.ShiroAnnotationProcessorAutoConfiguration#defaultAdvisorAutoProxyCreator()
 * 没有defaultAdvisorAutoProxyCreator.setProxyTargetClass(true); 会有问题
 *
 *
 * @author Anthony
 * @date 10/29/20
 **/
@Configuration
public class TestConfig {
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
}
