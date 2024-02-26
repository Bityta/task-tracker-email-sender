package ru.app.tasktrackeremailsender.rabbitMQ.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.app.tasktrackeremailsender.email.model.dto.email.EmailDto;
import ru.app.tasktrackeremailsender.rabbitMQ.service.publisher.RabbitMQPublisherService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
@Tag(name = "Message", description = "Methods for working with message send")
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    private final RabbitMQPublisherService rabbitMQPublisherService;

    /**
     * Endpoint for sending greetings message.
     *
     * @param emailDto The email to which the greetings message will be sent.
     * @return ResponseEntity indicating the status of the operation.
     */
    @Operation(
            description = "Sending greetings message",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            value = """
                                                            {
                                                                "email": "example@gmail.com"
                                                            }
                                                    """
                                    )
                            }
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful sending of greetings message",
                            content = @Content(
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request",
                            content = @Content(
                            )
                    )
            }
    )
    @PostMapping("/greetings")
    public ResponseEntity<String> sendGreetingsMessage(@RequestBody EmailDto emailDto) {
        LOGGER.info("Received request to send greetings message {} ", emailDto.getEmail());
        this.rabbitMQPublisherService.sendGreetingsMessage(emailDto.getEmail());
        LOGGER.info("Greetings message send successfully {} ", emailDto.getEmail());
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
