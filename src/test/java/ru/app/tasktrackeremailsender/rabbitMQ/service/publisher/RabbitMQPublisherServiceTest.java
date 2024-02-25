package ru.app.tasktrackeremailsender.rabbitMQ.service.publisher;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RabbitMQPublisherServiceTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private RabbitMQPublisherService rabbitMQPublisherService;

    @Test
    public void testSendGreetingsMessage() {

        Mockito.doNothing().when(rabbitTemplate).convertAndSend(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
        );

        this.rabbitMQPublisherService.sendGreetingsMessage("123");

    }
}

