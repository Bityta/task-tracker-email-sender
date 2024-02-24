package ru.app.tasktrackeremailsender.rabbitMQ.service.publisher;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.app.tasktrackeremailsender.email.service.EmailService;

@Service
@RequiredArgsConstructor
public class RabbitMQPublisherService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQPublisherService.class);
    private final RabbitTemplate rabbitTemplate;
    private final EmailService emailService;
    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.key}")
    private String key;
    private static final String GREETINGS_HEADER = "Greetings from Task-tracker-email-sender";
    private static final String GREETINGS_BODY = "Thank you for registering";


    public void sendGreetingsMessage(String email) {
        logger.info(String.format("Message sent -> %s", email));
        this.emailService.sendMessage(email, GREETINGS_HEADER, GREETINGS_BODY);
        this.rabbitTemplate.convertAndSend(exchange, key, email);
    }

}
