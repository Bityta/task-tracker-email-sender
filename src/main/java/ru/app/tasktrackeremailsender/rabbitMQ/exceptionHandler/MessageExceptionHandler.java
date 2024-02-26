package ru.app.tasktrackeremailsender.rabbitMQ.exceptionHandler;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.mail.SendFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.app.tasktrackeremailsender.exception.model.dto.ErrorMessageDtoView;
import ru.app.tasktrackeremailsender.rabbitMQ.controller.MessageController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice(assignableTypes = MessageController.class)
@Hidden
public class MessageExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageExceptionHandler.class);

    /**
     * Exception handler for handling SendFailedException.
     *
     * @param ex The SendFailedException that occurred.
     * @return Map containing error details.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SendFailedException.class)
    public Map<String, String> handleSendFailedException(SendFailedException ex) {
        LOGGER.error("An error occurred while sending greetings message. {}", ex.getMessage());
        ErrorMessageDtoView errors = ErrorMessageDtoView.builder()
                .status(HttpStatus.BAD_REQUEST)
                .error(ex.getMessage())
                .path("/")
                .build();

        return errors.getError();
    }

    /**
     * Handles MethodArgumentNotValidException and returns a response with HTTP status code 400 Bad Request.
     *
     * @param ex The MethodArgumentNotValidException instance.
     * @return A map containing error information.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        LOGGER.error("User data validation error. {}", ex.getMessage());

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorMessageDtoView error = ErrorMessageDtoView.builder()
                .status(HttpStatus.BAD_REQUEST)
                .error(errors.keySet().stream()
                        .map(errors::get)
                        .collect(Collectors.joining(". ")))
                .path("/tasks")
                .build();

        return error.getError();
    }
}
