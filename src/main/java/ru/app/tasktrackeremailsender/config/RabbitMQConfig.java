package ru.app.tasktrackeremailsender.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    @Value("${rabbitmq.queue}")
    private String queueName;

    @Value("${rabbitmq.exchange}")
    private String exchangeName;


    @Value("${rabbitmq.key}")
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
