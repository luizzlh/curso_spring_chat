package com.cursochat.cursospring.repositories;

import com.cursochat.cursospring.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    List<Aluno> findByNomeContainingIgnoreCase(String nome);

}