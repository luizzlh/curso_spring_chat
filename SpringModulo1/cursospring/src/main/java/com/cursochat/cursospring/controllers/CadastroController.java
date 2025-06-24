package com.cursochat.cursospring.controllers;

import com.cursochat.cursospring.models.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class CadastroController {

    private ArrayList<Aluno> alunos = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("aluno", new Aluno());
        return "cadastro";
    }

    @PostMapping("/enviar")
    public String cadastrarAluno(@ModelAttribute Aluno aluno){
        alunos.add(aluno);
        return "redirect:/";
    }

    @GetMapping("/lista")
    public String listarAlunos(Model model){
        model.addAttribute("alunos", alunos);
        return "lista";
    }


}