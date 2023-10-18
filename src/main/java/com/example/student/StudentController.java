package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//API LAYER

//Questa notazione rende la classe capace di fornire dei Rest Endpoints
@RestController
@RequestMapping    //Questo path viene aggiunto a localhost:8080, quindi farà il mapping di questa classe
public class StudentController {
    private final StudentService studentService;

    //Dice al programma che questo è uno Spring Bean, facendo un inject della classe studentService per via della sua notazione @Component
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //Per fare in modo che questo metodo sia servito come Rest Endpoint, usiamo la notazione
    //http://localhost:8080/studentAPI
    @GetMapping("/studentAPI")
    public List<Student> getStudents(){
        return studentService.getStudent();
    }

    //Usato per creare nuove risorse nel sistema
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){   //RequestBody prende il Body dal cliente e lo mappa in Student
        studentService.addNewStudent(student);
    }
}


