package com.zeroone.star.message.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue queue() {
        return new Queue("queue4SystemNotice", false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange4SystemNotice");
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("routing4SystemNotice.key");
    }

}
