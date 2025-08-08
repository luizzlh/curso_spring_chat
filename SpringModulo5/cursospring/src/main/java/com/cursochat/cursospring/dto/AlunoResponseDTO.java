package com.cursochat.cursospring.dto;

import com.cursochat.cursospring.models.Aluno;

public class AlunoResponseDTO {
    private int id;
    private String nome;
    private String curso;

    public AlunoResponseDTO(int id, String nome, String curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
    }

    public AlunoResponseDTO(Aluno salvo) {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }
}