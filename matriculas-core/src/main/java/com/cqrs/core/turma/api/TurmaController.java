package com.cqrs.core.turma.api;

import com.cqrs.core.turma.application.TurmaApplicationService;
import com.cqrs.core.turma.application.commands.CriarTurmaCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    private TurmaApplicationService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> criar(@RequestBody CriarTurmaCommand command) {
        return ResponseEntity.ok(service.criar(command));
    }
}
