package com.example.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    //Questa notazione, l'entità va in un manage state
    @Transactional
    public void updateStudent(Long id,
                              String nome,
                              String email) {

        //salvo lo studente con x id, o lancio errore in caso non esista
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Questo studente non esiste"));

        //Se il nome inserito non è nullo, vuoto e non corrisponde a quello già presente all'id, allora modifica il nome della riga id
        if (nome != null && !nome.isEmpty() && !Objects.equals(student.getNome(), nome)) {
            student.setNome(nome);
        }

        //Come sopra ma per email
        if (email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)) {

            //Controllo che la mail non sia presa, se è libera procedo quindi con l'update dei dati
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("This email is taken");
            }
            student.setEmail(email);
        }

    }
}
