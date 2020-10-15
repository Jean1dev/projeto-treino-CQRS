package com.cqrs.query.aluno.service;

import com.cqrs.query.aluno.amqp.domain.repository.AlunoRepository;
import com.cqrs.query.aluno.amqp.event.AlunoEvent;
import com.cqrs.query.aluno.domain.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlunoCriadoService {

    @Autowired
    private AlunoRepository repository;

    public void handle(AlunoEvent event) {
        Aluno aluno = Aluno.builder()
                .formaIngresso(event.getFormaIngresso())
                .id(event.getId())
                .matricula(event.getMatricula())
                .nome(event.getNome())
                .build();

        repository.save(aluno);
    }
}
