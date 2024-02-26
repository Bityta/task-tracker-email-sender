package ru.app.tasktrackeremailsender.rabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for RabbitMQ setup.
 */
@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.greetings}")
    private String queueNameGreetings;

    @Value("${rabbitmq.queue.analytics}")
    private String queueNameAnalytics;

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

    @Value("${rabbitmq.key.greetings}")
    private String routingKeyGreetings;

    @Value("${rabbitmq.key.analytics}")
    private String routingKeyAnalytics;

    /**
     * Bean definition for creating the message queue for greetings.
     *
     * @return A Queue instance.
     */
    @Bean
    public Queue queueGreetings() {
        return new Queue(this.queueNameGreetings);
    }

    /**
     * Bean definition for creating the message queue for analytics.
     *
     * @return A Queue instance.
     */
    @Bean
    public Queue queueAnalytics() {
        return new Queue(this.queueNameAnalytics);
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
     * Bean definition for creating the binding between greetings queue and exchange.
     *
     * @param queueGreetings The greetings queue.
     * @param exchange       The topic exchange.
     * @return A Binding instance.
     */
    @Bean
    public Binding bindingGreetings(Queue queueGreetings, TopicExchange exchange) {
        return BindingBuilder.bind(queueGreetings).to(exchange).with(this.routingKeyGreetings);
    }

    /**
     * Bean definition for creating the binding between analytics queue and exchange.
     *
     * @param queueAnalytics The analytics queue.
     * @param exchange       The topic exchange.
     * @return A Binding instance.
     */
    @Bean
    public Binding bindingAnalytics(Queue queueAnalytics, TopicExchange exchange) {
        return BindingBuilder.bind(queueAnalytics).to(exchange).with(this.routingKeyAnalytics);
    }

    /**
     * Bean definition for creating the Jackson2JsonMessageConverter.
     *
     * @return A Jackson2JsonMessageConverter instance.
     */
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Bean definition for creating the RabbitTemplate.
     *
     * @param connectionFactory The connection factory.
     * @return A RabbitTemplate instance.
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(this.jsonMessageConverter());
        return rabbitTemplate;
    }
}
