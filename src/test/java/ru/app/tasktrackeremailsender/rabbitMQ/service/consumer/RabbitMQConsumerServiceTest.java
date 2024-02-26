package ru.app.tasktrackeremailsender.rabbitMQ.service.consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.app.tasktrackeremailsender.email.service.EmailService;
import ru.app.tasktrackeremailsender.rabbitMQ.model.dto.EmailAnalyticsDto;
import ru.app.tasktrackeremailsender.rabbitMQ.model.dto.EmailGreetingsDto;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
public class RabbitMQConsumerServiceTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private RabbitMQConsumerService rabbitMQConsumerService;

    @Test
    public void testConsumeGreetings() {
        var emailGreetingsDto = EmailGreetingsDto.builder()
                        .email("test@gmail.com")
                                .build();

        Mockito.doNothing().when(emailService).sendMessage(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
        );

        rabbitMQConsumerService.consumeGreetings(emailGreetingsDto);
        Mockito.verify(emailService, times(1)).sendMessage(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
        );
    }


    @Test
    public void testConsumeAnalytics() {
        var emailAnalyticsDto = EmailAnalyticsDto.builder()
                .email("test@gmail.com")
                .body("test")
                .header("header")
                .build();

        Mockito.doNothing().when(emailService).sendMessage(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
        );

        rabbitMQConsumerService.consumeAnalytics(emailAnalyticsDto);
        Mockito.verify(emailService, times(1)).sendMessage(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
        );
    }
}
