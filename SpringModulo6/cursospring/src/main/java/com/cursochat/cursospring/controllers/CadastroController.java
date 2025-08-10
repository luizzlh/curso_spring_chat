package com.cursochat.cursospring.controllers;

import com.cursochat.cursospring.models.Aluno;
import com.cursochat.cursospring.repositories.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class CadastroController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/cadastro")
    public String index(Model model){
        model.addAttribute("aluno", new Aluno());
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarAluno(@Valid @ModelAttribute Aluno aluno,
                                BindingResult result,
                                Model model){
        if (result.hasErrors()){
            return "cadastro";
        }

        alunoRepository.save(aluno);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String listarAlunos(@RequestParam(required = false) String nome, Model model){
        List<Aluno> alunos;

        if (nome != null && !nome.isEmpty()){
            alunos = alunoRepository.findByNomeContainingIgnoreCase(nome);
        } else{
            alunos = alunoRepository.findAll();
        }

        model.addAttribute("alunos", alunos);
        model.addAttribute("nome", nome);
        return "lista";
    }

    @GetMapping("/editar/{id}")
    public String editarAluno(@PathVariable int id, Model model) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        if(aluno.getId() == id){
            model.addAttribute("aluno", aluno);
            return "cadastro";
        }
        return "redirect:/lista";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAluno(@PathVariable int id){
        alunoRepository.deleteById(id);
        return "redirect:/lista";
    }
}