package ru.app.tasktrackeremailsender.rabbitMQ.service.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumerService.class);

    @RabbitListener(queues = {"${rabbitmq.queue}"})
    public void consume(String email) {
        LOGGER.info(String.format("Received message -> %s", email));
    }

}
