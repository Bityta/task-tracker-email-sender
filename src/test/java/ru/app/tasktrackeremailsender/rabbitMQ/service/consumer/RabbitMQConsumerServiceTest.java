package ru.app.tasktrackeremailsender.rabbitMQ.service.consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.app.tasktrackeremailsender.email.service.EmailService;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
public class RabbitMQConsumerServiceTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private RabbitMQConsumerService rabbitMQConsumerService;

    @Test
    public void testConsume() {
        String email = "test@example.com";
        Mockito.doNothing().when(emailService).sendMessage(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
        );

        rabbitMQConsumerService.consume(email);
        Mockito.verify(emailService, times(1)).sendMessage(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
        );
    }
}
