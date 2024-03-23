# Task Tracker Email Sender

## Overview

Task Tracker Email Sender is a Spring Boot application responsible for sending emails by processing messages received from other services via RabbitMQ.
It is configured to run with different profiles depending on the environment: `ide` for local development and `prod` for production.

The main goal of the Task Tracker Email Sender service is to automate the process of sending email notifications to users based on data received from other services. This service aims to efficiently inform users about various events and changes in the system, such as task completions, upcoming reminders, and providing them with relevant information for task and process management. This enhances the usability of the system and ensures timely notification of users, thereby increasing their satisfaction and productivity.

Additional project details can be found in the Task Tracker Info.  Please refer to it [here](https://github.com/Bityta/task-tracker-info).


## Description

This application comprises two modules - Spring Mail and Spring AMQP. It connects to RabbitMQ using Spring AMQP, and subscribes to messages sent by the scheduler and backend service.
For each received message, deserialized into a model instance, the Spring Mail module is utilized to send an email.

## Getting Started

Before starting the `task-tracker-email-sender` microservice, ensure that the `task-tracker-service-discovery` microservice is up and running, as it is required for proper functionality.

You can find the `task-tracker-service-discovery` microservice [here](https://github.com/Bityta/task-tracker-service-discovery).


To run the application locally using Docker Compose, follow these steps:

1. Clone the repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd task-tracker-email-sender`
3. Configure your desired profile by uncommenting the corresponding section in the application.yml file.
4. Build the Docker image: `docker-compose build`
5. Run the Docker container: `docker-compose up`

This will build the Docker image for the application and start the container.

Once the container is up and running, the application will be accessible at `http://localhost:8081`.


### Profiles

- **ide**: This profile is used for local development. It is configured to run on port `8081`. The basic settings for rabbitmq have already been set. You will need to provide the mail and password to work sending messages.

- **prod**: This profile is used for production deployment. It runs on port `8081`. You will need to provide the mail and password to work sending messages. Also specify a number of RabbitMQ settings

To select a profile, go to application.yml and change the spring:
```yaml
application:
    profiles:
      active: your-profile
  ```

Path to the application.yml file: `src\main\resources`

Replace your-profile with an ide or prod

Here's an example configuration:

```yaml
spring:
  config:
    activate:
      on-profile: prod

  mail:
    host: smtp.gmail.com
    port: 587
    username: your-mail
    password: your-password
    properties.mail.smtp:
      auth: true
      starttls.enable: true
      ssl.trust: smtp.gmail.com
```

Replace your-mail and your-password with the actual  mail and password
To find out the password, look at the instructions: [here](https://support.google.com/accounts/answer/185833)

```yaml
rabbitmq:
  key:
    greetings: your-key-1
    analytics: your-key-2
  queue:
    greetings: your-queue-1
    analytics: your-queue-2
  exchange: your-exchange
```
Replace your-key-1 and your-key-2 with any name of the rabbitmq key, your-queue-1 and your-queue-2 with any name of the rabbitmq queue and your-exchange with any value of the rabbitmq exchange


## Dependencies
- Spring Boot
- Spring AMQP
- RabbitMQ
- Spring Data JPA
- Spring Cloud Eureka Client


## Contributing

Contributions are welcome! Feel free to submit pull requests or open issues for any improvements or bug fixes.

