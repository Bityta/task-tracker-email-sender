package ru.app.tasktrackeremailsender.rabbitMQ.service.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service class for publishing messages to RabbitMQ.
 */
@Service
@RequiredArgsConstructor
public class RabbitMQPublisherService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.key}")
    private String key;

    /**
     * Method to send a greetings message to RabbitMQ.
     *
     * @param email The email address to send the greetings message to.
     */
    public void sendGreetingsMessage(String email) {
        this.rabbitTemplate.convertAndSend(exchange, key, email);
    }
}
