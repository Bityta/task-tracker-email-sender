package ru.app.tasktrackeremailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskTrackerEmailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskTrackerEmailSenderApplication.class, args);
    }

    //создаем рабочий проект по rabbitMQ + упаковываем в контейнер и подключаем к backend,
    //по госту все оформляем

    //логирование
    //тесты + документация + swagger


}
