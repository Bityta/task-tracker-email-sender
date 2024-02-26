package ru.app.tasktrackeremailsender.email.model.dto.email;

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
@Schema(name = "Email", description = "Information about email")
public class EmailDto {
    /**
     * The email address.
     */
    private String email;
}
