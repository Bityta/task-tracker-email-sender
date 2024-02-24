package ru.app.tasktrackeremailsender.rabbitMQ.exceptionHandler;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.mail.SendFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.app.tasktrackeremailsender.exception.model.dto.ErrorMessageDtoView;
import ru.app.tasktrackeremailsender.rabbitMQ.controller.MessageController;

import java.util.Map;

@RestControllerAdvice(assignableTypes = MessageController.class)
@Hidden()
public class MessageExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageExceptionHandler.class);

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

}
