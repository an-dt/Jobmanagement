package com.an_dt.Jobmanagement.config;


import org.springframework.amqp.core.*;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue jobStoppingQueue() {
        return new Queue("jobStoppingQueue", true,false, true);
    }

    @Bean
    public TopicExchange jobStoppingExchange() {
        return new TopicExchange("jobStoppingExchange");
    }

    @Bean
    public Binding binding(Queue jobStoppingQueue, TopicExchange jobStoppingExchange) {
        return BindingBuilder.bind(jobStoppingQueue).to(jobStoppingExchange).with("jobStoppingRoutingKey");
    }
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }

}
