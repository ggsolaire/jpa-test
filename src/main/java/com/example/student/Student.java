package com.example.student;
//Maven Dependency: Jakarta.persistance-api
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

//Questa è una semplice classe per l'entità student, poi convertita tramite Spring JPA in table, convertendone le proprietà in colonne

//Per MAPPARE questa classe in una table, dobbiamo utilizzare la notazione seguente, che ci permette di mapparla nel database

@Entity
@Table
public class Student {
    //Notazione per definire la PK all'interno del database
    @Id
    private Long id;
    private String nome;
    private LocalDate compleanno;
    private Integer anni;


    public Student(){
        id = null;
        nome = "";
        compleanno = null;
        anni = null;
    }
    public Student(Long id, String nome, LocalDate compleanno, Integer anni) {
        this.id = id;
        this.nome = nome;
        this.compleanno = compleanno        ;
        this.anni = anni;
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

    public Integer getAnni() {
        return anni;
    }

    public void setAnni(Integer anni) {
        this.anni = anni;
    }
}
