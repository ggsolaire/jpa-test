package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
//SERVICE LAYER
//Indica una classe che va istanziata, ovvero deve essere uno Spring Bean (Come @Component, per leggibilità si usa service per dire che dà un servizio)
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {

        //Grazie al JPA ho moltissime funzioni a disposizione senza doverle implementare
        return studentRepository.findAll(); //Ritorna una lista
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }
//    Così facendo, la classe viene convertita in un JSON object

}
