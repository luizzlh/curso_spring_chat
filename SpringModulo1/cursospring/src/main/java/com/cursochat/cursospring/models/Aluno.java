package com.cursochat.cursospring.models;

public class Aluno {

    private String nome;
    private String curso;

    public Aluno() {
    }

    public Aluno(String curso, String nome) {
        this.curso = curso;
        this.nome = nome;
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
