package com.example.student;
//Maven Dependency: Jakarta.persistance-api
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;

//Questa è una semplice classe per l'entità student, poi convertita tramite Spring JPA in table, convertendone le proprietà in colonne

//Per MAPPARE questa classe in una table, dobbiamo utilizzare la notazione seguente, che ci permette di mapparla nel database

@Entity //Per Hibernate
@Table  //Per mappare la classe come table nel db
public class Student {
    //Notazione per definire la PK all'interno del database
    @Id
    //Mappiamo la classe all'interno del db
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String nome;
    private LocalDate compleanno;

    //Questa notazione ci dice che si tratta di un'informazione ricavabile, in questo caso ad esempio dal compleanno
    @Transient
    private Integer anni;


    public Student(){
        id = null;
        nome = "";
        compleanno = null;
//        anni = null; Rimosso per il Transient
    }
    public Student(Long id, String nome, LocalDate compleanno /*Integer anni*/) {
        this.id = id;
        this.nome = nome;
        this.compleanno = compleanno;
//        this.anni = anni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getCompleanno() {
        return compleanno;
    }

    public void setCompleanno(LocalDate compleanno) {
        this.compleanno = compleanno;
    }

    //Dato che anni è calcolabile, allora qui inserisco un'operazione che me lo calcoli
    public Integer getAnni() {
        return Period.between(compleanno, LocalDate.now()).getYears();  //restituisce il numero di anni di differenza tra compleanno e la data odierna
    }

    public void setAnni(Integer anni) {
        this.anni = anni;
    }
}
