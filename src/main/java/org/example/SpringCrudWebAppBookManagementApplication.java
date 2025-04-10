package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication                                                                  // @SpringBootApplication — Класс, аннотированный @SpringBootApplication, является основным классом приложения Spring Boot, с него начинается работа приложения.
public class SpringCrudWebAppBookManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCrudWebAppBookManagementApplication.class, args);   // SpringApplication.run() — это статический метод класса SpringApplication, который запускает приложение Spring при старте
    }

}
