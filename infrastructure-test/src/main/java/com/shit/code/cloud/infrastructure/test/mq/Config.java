package com.shit.code.cloud.infrastructure.test.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anthony
 * @date 11/7/20
 **/
@Configuration
public class Config {
    @Bean
    public Queue directQueue() {
        return new Queue("testtrace", false); //队列名字，是否持久化
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("testtrace", false, false);//交换器名称、是否持久化、是否自动删除
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("testtrace");
    }
}
