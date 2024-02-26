package ru.app.tasktrackeremailsender.rabbitMQ.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "Email address")
    private String email;

    @Schema(description = "Header of the email")
    private String header;

    @Schema(description = "Body of the email")
    private String body;
}
