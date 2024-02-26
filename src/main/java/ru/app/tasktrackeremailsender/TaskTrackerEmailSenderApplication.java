package ru.app.tasktrackeremailsender;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to start the Task Tracker Email Sender application.
 */
@SpringBootApplication
@EnableRabbit
public class TaskTrackerEmailSenderApplication {

    /**
     * Main method to start the Task Tracker Email Sender application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(TaskTrackerEmailSenderApplication.class, args);
    }
}
