package com.cursochat.cursospring.controllers;

import com.cursochat.cursospring.models.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class CadastroController {

    private ArrayList<Aluno> alunos = new ArrayList<>();
    private int proximoId = 1;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("aluno", new Aluno());
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarAluno(@ModelAttribute Aluno aluno){
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId() == aluno.getId()) {
                alunos.set(i, aluno);
                return "redirect:/lista";
            }
        }

        aluno.setId(proximoId++);
        alunos.add(aluno);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String listarAlunos(Model model){
        model.addAttribute("alunos", alunos);
        return "lista";
    }

    @GetMapping("/editar/{id}")
    public String editarAluno(@PathVariable int id, Model model) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                model.addAttribute("aluno", aluno);
                return "cadastro";
            }
        }
        return "redirect:/lista";
    }



}