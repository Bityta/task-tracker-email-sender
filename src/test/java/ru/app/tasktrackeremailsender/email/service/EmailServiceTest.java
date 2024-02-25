package ru.app.tasktrackeremailsender.email.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailService emailService;

    @Test
    void sendMessage_ShouldSendEmailSuccessfully() {
        String to = "recipient@example.com";
        String subject = "Test Subject";
        String text = "Test Message";

        doNothing().when(javaMailSender).send(Mockito.any(SimpleMailMessage.class));
        emailService.sendMessage(to, subject, text);

        verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}
