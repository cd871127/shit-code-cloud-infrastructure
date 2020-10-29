package com.shit.code.cloud.infrastructure.security.configuration;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anthony
 * @date 10/29/20
 **/
@Configuration
public class ShiroAdvisorConfiguration {

    /**
     * 这个bean覆盖org.apache.shiro.spring.boot.autoconfigure.ShiroAnnotationProcessorAutoConfiguration#defaultAdvisorAutoProxyCreator()
     * 没有defaultAdvisorAutoProxyCreator.setProxyTargetClass(true); 会有问题
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        //一定要有下面这一行
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
}
