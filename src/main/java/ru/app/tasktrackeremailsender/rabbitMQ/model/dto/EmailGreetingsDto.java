package ru.app.tasktrackeremailsender.rabbitMQ.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Data Transfer Object (DTO) for representing an email.
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "EmailGreetingsDto", description = "Information about email")
public class EmailGreetingsDto {
    /**
     * The email address.
     */
    private String email;
}
