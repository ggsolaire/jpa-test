package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //    Così facendo, la classe viene convertita in un JSON object
    public void addNewStudent(Student student) {

        //Verifico che la mail che si sta provando a salvare non sia già presente nel sistema
        //Se è presente, lancio un errore, altrimenti salvo
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        } else {
            studentRepository.save(student);
        }
    }

    public void removeStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalStateException("Questo studente non esiste");
        } else {
            studentRepository.deleteById(id);
        }
    }

}
