package ru.app.tasktrackeremailsender.rabbitMQ.service.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQPublisherService {

    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.key}")
    private String key;

    public void sendGreetingsMessage(String email) {
        this.rabbitTemplate.convertAndSend(exchange, key, email);
    }

}
