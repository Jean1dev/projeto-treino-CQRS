package com.cqrs.core.professor.api;

import com.cqrs.core.professor.application.ProfessorApplicationService;
import com.cqrs.core.professor.application.commands.CriarProfessorCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("professor")
public class ProfessorController {

    @Autowired
    private ProfessorApplicationService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> criar(@RequestBody CriarProfessorCommand command) {
        return ResponseEntity.ok(service.criar(command));
    }
}
