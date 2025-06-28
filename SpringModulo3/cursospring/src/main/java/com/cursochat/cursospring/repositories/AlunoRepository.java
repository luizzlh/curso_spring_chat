package com.cursochat.cursospring.repositories;

import com.cursochat.cursospring.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}