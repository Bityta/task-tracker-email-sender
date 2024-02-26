package ru.app.tasktrackeremailsender.rabbitMQ.service.publisher;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.app.tasktrackeremailsender.rabbitMQ.model.dto.EmailAnalyticsDto;
import ru.app.tasktrackeremailsender.rabbitMQ.model.dto.EmailGreetingsDto;

@ExtendWith(SpringExtension.class)
public class RabbitMQPublisherServiceTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private RabbitMQPublisherService rabbitMQPublisherService;

    @Test
    public void testSendGreetingsMessage() {
        var emailGreetingsDto = EmailGreetingsDto.builder()
                .email("test@gmail.com")
                .build();


        Mockito.doNothing().when(rabbitTemplate).convertAndSend(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
        );

        this.rabbitMQPublisherService.sendGreetingsMessage(emailGreetingsDto);

    }

    @Test
    public void testSendAnalyticsMessage() {
        var emailAnalyticsDto = EmailAnalyticsDto.builder()
                .email("test@gmail.com")
                .body("test")
                .header("header")
                .build();


        Mockito.doNothing().when(rabbitTemplate).convertAndSend(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
        );

        this.rabbitMQPublisherService.sendAnalyticsMessage(emailAnalyticsDto);

    }
}

