package ru.app.tasktrackeremailsender.rabbitMQ.model.dto.email;

import org.junit.jupiter.api.Test;
import ru.app.tasktrackeremailsender.rabbitMQ.model.dto.EmailGreetingsDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailGreetingsDtoTest {

    @Test
    public void testConstructorAndGetters() {
        String email = "test@example.com";
        EmailGreetingsDto emailGreetingsDto = new EmailGreetingsDto(email);
        assertEquals(email, emailGreetingsDto.getEmail());
    }

    @Test
    public void testSetter() {
        String email = "test@example.com";
        EmailGreetingsDto emailGreetingsDto = EmailGreetingsDto.builder()
                .email(email)
                .build();
        emailGreetingsDto.setEmail(email);
        assertEquals(email, emailGreetingsDto.getEmail());
    }
}
