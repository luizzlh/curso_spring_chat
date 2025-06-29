package com.cursochat.cursospring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 2, message = "O nome deve ter no mínimo 2 letras!")
    private String nome;

    @NotBlank(message = "O curso é obrigatório!")
    private String curso;

    public Aluno() {
    }

    public Aluno(String curso, String nome) {
        this.curso = curso;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}