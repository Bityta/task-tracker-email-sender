package ru.app.tasktrackeremailsender.rabbitMQ.service.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.app.tasktrackeremailsender.email.service.EmailService;

@Service
@RequiredArgsConstructor
public class RabbitMQPublisherService {

    private static final String GREETINGS_HEADER = "Greetings from Task-tracker-email-sender";
    private static final String GREETINGS_BODY = "Thank you for registering";
    private final RabbitTemplate rabbitTemplate;
    private final EmailService emailService;
    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.key}")
    private String key;

    public void sendGreetingsMessage(String email) {
        this.emailService.sendMessage(email, GREETINGS_HEADER, GREETINGS_BODY);
        this.rabbitTemplate.convertAndSend(exchange, key, email);
    }

}
