package ru.app.tasktrackeremailsender.rabbitMQ.service.consumer;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.app.tasktrackeremailsender.email.service.EmailService;

/**
 * Service class for consuming messages from RabbitMQ.
 */
@Service
@RequiredArgsConstructor
public class RabbitMQConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumerService.class);
    private static final String GREETINGS_HEADER = "Greetings from Task-tracker-email-sender";
    private static final String GREETINGS_BODY = "Thank you for registering";

    private final EmailService emailService;

    /**
     * RabbitMQ message listener method.
     *
     * @param email The email address received from the message queue.
     */
    @RabbitListener(queues = {"${rabbitmq.queue}"})
    public void consume(String email) {
        this.emailService.sendMessage(email, GREETINGS_HEADER, GREETINGS_BODY);
        LOGGER.info(String.format("Received message -> %s", email));
    }

}
