package com.elif.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.queue}")
    private String queue;
    @Value("${rabbitmq.binding_key}")
    private String bindingKey;

    @Bean
    DirectExchange directExchangeAuth(){
        return new DirectExchange(exchange);
    }

    @Bean
    Queue queueAuth(){
        return new Queue(queue);
    }

    @Bean
    public Binding bindingKeyAuth(final DirectExchange directExchangeAuth, final Queue queueAuth){
        return BindingBuilder.bind(queueAuth)
                .to(directExchangeAuth)
                .with(bindingKey);
    }


}
