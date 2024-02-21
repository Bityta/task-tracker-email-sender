package ru.app.tasktrackeremailsender.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;


    @Value("${rabbitmq.key.name}")
    private String keyName;

    @Bean
    public Queue queue() {
        return new Queue(this.queueName);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(this.exchangeName);
    }

    @Bean
    public Binding Binding() {
        return BindingBuilder.bind(this.queue())
                .to(this.exchange())
                .with(this.keyName);
    }
}
