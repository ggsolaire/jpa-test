package com.example.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    //Richiede un bean all'interno

    //Inject della classe
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student luigi = new Student(
                    1L,
                    "Luigi",
                    LocalDate.of(2002, Month.MARCH, 31)
//                    21
            );

            Student marco = new Student(
                    2L,
                    "Andrea",
                    LocalDate.of(2002, Month.OCTOBER, 30)
//                    20
            );

            //Inserisce nel database, vedere Log Hibernate per le query generate
            repository.saveAll(List.of(luigi, marco));
        };
    }
}
