package ru.app.tasktrackeremailsender.rabbitMQ.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailAnalyticsDtoTest {

    @Test
    public void testGetEmail() {
        // Given
        String email = "test@example.com";
        EmailAnalyticsDto dto = new EmailAnalyticsDto(email, "header", "body");

        // When
        String retrievedEmail = dto.getEmail();

        // Then
        assertEquals(email, retrievedEmail);
    }

    @Test
    public void testSetEmail() {
        // Given
        String email = "test@example.com";
        EmailAnalyticsDto dto = new EmailAnalyticsDto();

        // When
        dto.setEmail(email);

        // Then
        assertEquals(email, dto.getEmail());
    }

    @Test
    public void testGetHeader() {
        // Given
        String header = "Test Header";
        EmailAnalyticsDto dto = new EmailAnalyticsDto("email@example.com", header, "body");

        // When
        String retrievedHeader = dto.getHeader();

        // Then
        assertEquals(header, retrievedHeader);
    }

    @Test
    public void testSetHeader() {
        // Given
        String header = "Test Header";
        EmailAnalyticsDto dto = new EmailAnalyticsDto();

        // When
        dto.setHeader(header);

        // Then
        assertEquals(header, dto.getHeader());
    }

    @Test
    public void testGetBody() {
        // Given
        String body = "Test Body";
        EmailAnalyticsDto dto = new EmailAnalyticsDto("email@example.com", "header", body);

        // When
        String retrievedBody = dto.getBody();

        // Then
        assertEquals(body, retrievedBody);
    }

    @Test
    public void testSetBody() {
        // Given
        String body = "Test Body";
        EmailAnalyticsDto dto = new EmailAnalyticsDto();

        // When
        dto.setBody(body);

        // Then
        assertEquals(body, dto.getBody());
    }
}
