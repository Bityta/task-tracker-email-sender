package ru.app.tasktrackeremailsender.rabbitMQ.model.dto.email;

import org.junit.jupiter.api.Test;
import ru.app.tasktrackeremailsender.email.model.dto.email.EmailDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailDtoTest {

    @Test
    public void testConstructorAndGetters() {
        String email = "test@example.com";
        EmailDto emailDto = new EmailDto(email);
        assertEquals(email, emailDto.getEmail());
    }

    @Test
    public void testSetter() {
        String email = "test@example.com";
        EmailDto emailDto = EmailDto.builder()
                .email(email)
                .build();
        emailDto.setEmail(email);
        assertEquals(email, emailDto.getEmail());
    }
}
