package ru.app.tasktrackeremailsender.rabbitMQ.service.consumer;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.app.tasktrackeremailsender.email.service.EmailService;
import ru.app.tasktrackeremailsender.rabbitMQ.model.dto.EmailDto;
import ru.app.tasktrackeremailsender.rabbitMQ.model.dto.EmailGreetingsDto;

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
     * Listens for greetings messages from RabbitMQ and sends them via email.
     *
     * @param emailGreetingsDto The greetings message received from RabbitMQ.
     */
    @RabbitListener(queues = {"${rabbitmq.queue.greetings}"})
    public void consumeGreetings(EmailGreetingsDto emailGreetingsDto) {
        this.emailService.sendMessage(emailGreetingsDto.getEmail(), GREETINGS_HEADER, GREETINGS_BODY);
        LOGGER.info(String.format("Received message -> %s", emailGreetingsDto.getEmail()));
    }

    /**
     * Listens for analytics messages from RabbitMQ and sends them via email.
     *
     * @param emailDto The message received from RabbitMQ.
     */
    @RabbitListener(queues = {"${rabbitmq.queue.analytics}"})
    public void consumeAnalytics(EmailDto emailDto) {
        this.emailService.sendMessage(emailDto.getEmail(), emailDto.getHeader(), emailDto.getBody());
        LOGGER.info(String.format("Received message -> %s", emailDto.getEmail()));
    }
}
