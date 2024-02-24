package ru.app.tasktrackeremailsender.rabbitMQ.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.app.tasktrackeremailsender.rabbitMQ.service.publisher.RabbitMQPublisherService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {

    private final RabbitMQPublisherService rabbitMQPublisherService;


    @PostMapping("/greetings")
    public ResponseEntity<String> sendGreetingsMessage(@RequestBody String email) {
        this.rabbitMQPublisherService.sendGreetingsMessage(email);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
