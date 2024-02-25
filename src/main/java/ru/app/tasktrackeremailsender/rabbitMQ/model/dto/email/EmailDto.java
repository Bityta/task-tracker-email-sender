package ru.app.tasktrackeremailsender.rabbitMQ.model.dto.email;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
@Schema(name = "Email", description = "Information about email")
public class EmailDto {
    private String email;
}
