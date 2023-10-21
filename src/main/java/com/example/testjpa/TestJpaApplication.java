package com.example.testjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example" })
/*
* Dice al programma dove cercare per le entità da mappare
* Usare questo anziché ComponentScan perché altrimenti non genera la query per qualche motivo
*/
@EntityScan(basePackages = {"com.example.student", "com.example.testjpa"})
//Da aggiungere per dire al JPA di cercare le Repositories in determinati punti, poiché suddiviso in più packages
@EnableJpaRepositories("com.example.student")
public class TestJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestJpaApplication.class, args);
    }

}
