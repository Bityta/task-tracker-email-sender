package ru.app.tasktrackeremailsender.rabbitMQ.service.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.app.tasktrackeremailsender.rabbitMQ.model.dto.EmailDto;
import ru.app.tasktrackeremailsender.rabbitMQ.model.dto.EmailGreetingsDto;

/**
 * Service class for publishing messages to RabbitMQ.
 */
@Service
@RequiredArgsConstructor
public class RabbitMQPublisherService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.key.greetings}")
    private String routingKeyGreetings;

    @Value("${rabbitmq.key.analytics}")
    private String routingKeyAnalytics;

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

    /**
     * Sends a greetings message to RabbitMQ.
     *
     * @param emailGreetingsDto The greetings message to send.
     */
    public void sendGreetingsMessage(EmailGreetingsDto emailGreetingsDto) {
        this.rabbitTemplate.convertAndSend(exchangeName, routingKeyGreetings, emailGreetingsDto);
    }

    /**
     * Sends an analytics message to RabbitMQ.
     *
     * @param emailDto The message to send.
     */
    public void sendAnalyticsMessage(EmailDto emailDto) {
        this.rabbitTemplate.convertAndSend(exchangeName, routingKeyAnalytics, emailDto);
    }
}
