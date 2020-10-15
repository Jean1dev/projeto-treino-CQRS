package com.cqrs.core.aluno.api;

import com.cqrs.core.aluno.application.AlunoApplicationService;
import com.cqrs.core.aluno.application.commands.CriarAlunoCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoApplicationService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> criarAluno(@RequestBody CriarAlunoCommand criarAlunoCommand) {
        String id = service.criar(criarAlunoCommand);
        return ResponseEntity.ok(id);
    }
}
