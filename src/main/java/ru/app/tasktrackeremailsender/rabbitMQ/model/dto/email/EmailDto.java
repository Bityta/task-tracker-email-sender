package ru.app.tasktrackeremailsender.rabbitMQ.model.dto.email;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Email", description = "Information about email")
@Data
public class EmailDto {

    private String email;
}
