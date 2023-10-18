package com.example.testjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/*
* Dice al programma
*/
@ComponentScan(basePackages = {"com.example.student", "com.example.testjpa"})
public class TestJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestJpaApplication.class, args);
    }

}
