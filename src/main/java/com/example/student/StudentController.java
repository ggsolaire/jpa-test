package com.example.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//Classe contenente tutte le risorse per l'API

//Questa notazione rende la classe capace di fornire dei Rest Endpoints
@RestController
@RequestMapping    //Questo path viene aggiunto a localhost:8080, quindi farà il mapping di questa classe
public class StudentController {


    //Per fare in modo che questo metodo sia servito come Rest Endpoint, usiamo la notazione

    @GetMapping("/studentAPI")
    public List<Student> getStudent(){
        //JSON return List.of("Hello", "world!"); -> Ritorna un Array se si imposta tipo di ritorno a List<String>
        return List.of(new Student(
                1L,
                "Luigi",
                LocalDate.of(2002, Month.MARCH, 31),
                21
        ),
                new Student(
                        2L,"Marco",LocalDate.of(2003,Month.JANUARY,20),30
                ));
    }
//    Così facendo, la classe viene convertita in un JSON object

}


