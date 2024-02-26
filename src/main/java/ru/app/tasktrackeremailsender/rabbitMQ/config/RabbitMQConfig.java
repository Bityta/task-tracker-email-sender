package ru.app.tasktrackeremailsender.rabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for RabbitMQ setup.
 */
@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue}")
    private String queueName;

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

    @Value("${rabbitmq.key}")
    private String keyName;

    /**
     * Bean definition for creating the message queue.
     *
     * @return A Queue instance.
     */
    @Bean
    public Queue queue() {
        return new Queue(this.queueName);
    }

    /**
     * Bean definition for creating the topic exchange.
     *
     * @return A TopicExchange instance.
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(this.exchangeName);
    }

    /**
     * Bean definition for creating the binding between queue and exchange.
     *
     * @return A Binding instance.
     */
    @Bean
    public Binding Binding() {
        return BindingBuilder.bind(this.queue())
                .to(this.exchange())
                .with(this.keyName);
    }
}
