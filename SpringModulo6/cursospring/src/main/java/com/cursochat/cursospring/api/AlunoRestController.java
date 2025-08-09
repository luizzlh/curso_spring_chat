package com.cursochat.cursospring.api;

import com.cursochat.cursospring.dto.AlunoRequestDTO;
import com.cursochat.cursospring.dto.AlunoResponseDTO;
import com.cursochat.cursospring.models.Aluno;
import com.cursochat.cursospring.repositories.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
public class AlunoRestController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<AlunoResponseDTO> listarTodos() {
        return alunoRepository.findAll().stream()
                .map(aluno -> new AlunoResponseDTO(aluno.getId(), aluno.getNome(), aluno.getCurso())).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> buscar(@PathVariable int id) {
        return alunoRepository.findById(id)
                .map(aluno -> ResponseEntity.ok(new AlunoResponseDTO(aluno)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> criar(@RequestBody @Valid AlunoRequestDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setCurso(dto.getCurso());
        Aluno salvo = alunoRepository.save(aluno);

        URI location = URI.create("/api/alunos/" + salvo.getId());
        return ResponseEntity.created(location).body(new AlunoResponseDTO(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable int id, @RequestBody Aluno alunoAtualizado) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNome(alunoAtualizado.getNome());
                    aluno.setCurso(alunoAtualizado.getCurso());
                    return ResponseEntity.ok(alunoRepository.save(aluno));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}