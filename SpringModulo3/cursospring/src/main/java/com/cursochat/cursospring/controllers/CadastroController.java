package com.cursochat.cursospring.controllers;

import com.cursochat.cursospring.models.Aluno;
import com.cursochat.cursospring.repositories.AlunoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class CadastroController {

    private AlunoRepository alunoRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("aluno", new Aluno());
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarAluno(@ModelAttribute Aluno aluno){
        alunoRepository.save(aluno);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String listarAlunos(Model model){
        model.addAttribute("alunos", alunoRepository.findAll());
        return "lista";
    }

    @GetMapping("/editar/{id}")
    public String editarAluno(@PathVariable int id, Model model) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        model.addAttribute("aluno", aluno);
        return "redirect:/lista";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAluno(@PathVariable int id){
        alunoRepository.deleteById(id);
        return "redirect:/lista";
    }
}