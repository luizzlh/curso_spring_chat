package com.cursochat.cursospring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AlunoRequestDTO {

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 2, message = "Nome muito curto!")
    private String nome;

    @NotBlank(message = "O curso é obrigatório!")
    private String curso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
