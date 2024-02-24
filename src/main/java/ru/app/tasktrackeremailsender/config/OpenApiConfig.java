package ru.app.tasktrackeremailsender.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Alexander",
                        email = "Bituckihs@gmail.com"
                ),
                title = "Message Sender",
                description = "Rest Api Project for working with send message for email",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8081"
                )
        }
)
public class OpenApiConfig {
}
