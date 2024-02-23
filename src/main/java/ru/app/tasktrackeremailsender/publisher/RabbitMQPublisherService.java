package ru.app.tasktrackeremailsender.publisher;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQPublisherService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQPublisherService.class);

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.key}")
    private String key;


    private final RabbitTemplate rabbitTemplate;

    public void sendGreetingsMessage(String email){
        logger.info(String.format("Message sent -> %s", email));
        this.rabbitTemplate.convertAndSend(exchange, key, email);
    }

}
