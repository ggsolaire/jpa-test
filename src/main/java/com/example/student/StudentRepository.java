package com.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//INTERFACCIA CHE FA DA DATA ACCESS LAYER
//PERMETTENDOCI DI COMUNICARE CON IL DATABASE

//Interfaccia da implementare nel ClassService, con cui si interfaccia

//Indico la classe con cui deve lavorare ed il tipo dell'ID, in questo caso Long
//Possiamo creare delle funzionalità custom, ad esempio trovare un utente in base al nome
@Repository //Responsabile del Data Acess
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);   // @Query("SELECT s FROM Student s WHERE s.email = ?1")

}
