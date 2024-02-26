package ru.app.tasktrackeremailsender.rabbitMQ.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Data transfer object representing email analytics information.
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "EmailAnalyticsDto", description = "Information about email analytics")
public class EmailAnalyticsDto {

    /**
     * The email address.
     */
    @Schema(description = "Email address")
    @Size(min = 5, max = 50, message = "Email must contain from 5 to 50 characters")
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    /**
     * The header of the email.
     */
    @Schema(description = "Header of the email")
    @Size(min = 5, max = 50, message = "Header must contain from 5 to 50 characters")
    @NotBlank(message = "Header cannot be empty")
    private String header;

    /**
     * The body of the email.
     */
    @Schema(description = "Body of the email")
    @Size(min = 5, max = 4096, message = "Body must contain from 5 to 4096 characters")
    @NotBlank(message = "Body cannot be empty")
    private String body;
}
