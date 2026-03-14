package com.example.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUEUE = "my_queue";
    public static final String EXCHANGE = "my_exchange";

    @Bean public Queue queue() { return new Queue(QUEUE); }
    @Bean public DirectExchange exchange() { return new DirectExchange(EXCHANGE); }
    
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("routing_key");
    }
}
