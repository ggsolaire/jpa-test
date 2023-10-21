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
                    LocalDate.of(2002, Month.MARCH, 31),
                    "luigi.solaro@yahoo.com"
//                    21
            );

            Student marco = new Student(
                    2L,
                    "Marco",
                    LocalDate.of(1998, Month.DECEMBER, 22),
                    "watdafrag@gmail.com"
//                    20
            );

            //Inserisce nel database, vedere Log Hibernate per le query generate
            repository.saveAll(List.of(luigi, marco));
        };
    }
}
