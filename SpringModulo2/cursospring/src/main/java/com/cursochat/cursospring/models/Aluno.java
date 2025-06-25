package com.cursochat.cursospring.models;

public class Aluno {

    private int id;
    private String nome;
    private String curso;

    public Aluno() {
    }

    public Aluno(int id, String curso, String nome) {
        this.id = id;
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
