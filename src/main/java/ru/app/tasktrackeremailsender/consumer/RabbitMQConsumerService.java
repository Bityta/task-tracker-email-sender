package ru.app.tasktrackeremailsender.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitMQConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumerService.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String email) {
        logger.info(String.format("Received message -> %s", email));
    }

}
