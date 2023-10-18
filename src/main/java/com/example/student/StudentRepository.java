package com.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//INTERFACCIA CHE FA DA DATA ACCESS LAYER
//PERMETTENDOCI DI COMUNICARE CON IL DATABASE

//Interfaccia da implementare nel ClassService, con cui si interfaccia

//Indico la classe con cui deve lavorare ed il tipo dell'ID, in questo caso Long
@Repository //Responsabile del Data Acess
public interface StudentRepository extends JpaRepository<Student, Long> {

}
