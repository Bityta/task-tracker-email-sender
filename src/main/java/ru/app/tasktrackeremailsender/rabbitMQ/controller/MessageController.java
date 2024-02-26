package ru.app.tasktrackeremailsender.rabbitMQ.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.app.tasktrackeremailsender.rabbitMQ.model.dto.EmailAnalyticsDto;
import ru.app.tasktrackeremailsender.rabbitMQ.model.dto.EmailGreetingsDto;
import ru.app.tasktrackeremailsender.rabbitMQ.service.publisher.RabbitMQPublisherService;

/**
 * Controller class for handling message-related operations.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
@Validated
@Tag(name = "Message", description = "Methods for working with message sending")
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    private final RabbitMQPublisherService rabbitMQPublisherService;

    /**
     * Endpoint for sending a greetings message.
     *
     * @param emailGreetingsDto The email to which the greetings message will be sent.
     * @return ResponseEntity indicating the status of the operation.
     */
    @Operation(
            description = "Sending a greetings message",
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
                            description = "Successful sending of a greetings message",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request",
                            content = @Content()
                    )
            }
    )
    @PostMapping("/greetings")
    public ResponseEntity<String> sendGreetingsMessage(@Valid @RequestBody EmailGreetingsDto emailGreetingsDto) {
        LOGGER.info("Received request to send a greetings message {} ", emailGreetingsDto.getEmail());
        this.rabbitMQPublisherService.sendGreetingsMessage(emailGreetingsDto);
        LOGGER.info("Greetings message sent successfully {} ", emailGreetingsDto.getEmail());
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    /**
     * Endpoint for sending an analytics message.
     *
     * @param emailAnalyticsDto The email analytics data to be sent.
     * @return ResponseEntity indicating the status of the operation.
     */
    @Operation(
            description = "Sending an analytics message",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            value = """
                                                            {
                                                                "email": "example@gmail.com",
                                                                "header": "test",
                                                                "body": "test"
                                                            }
                                                    """
                                    )
                            }
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful sending of an analytics message",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request",
                            content = @Content()
                    )
            }
    )
    @PostMapping("/analytics")
    public ResponseEntity<String> sendAnalytics(@Valid @RequestBody EmailAnalyticsDto emailAnalyticsDto) {
        LOGGER.info("Received request to send an email message {} ", emailAnalyticsDto.getEmail());
        this.rabbitMQPublisherService.sendAnalyticsMessage(emailAnalyticsDto);
        LOGGER.info("Email message sent successfully {} ", emailAnalyticsDto.getEmail());
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
