package com.cqrs.query.aluno.service;

import com.cqrs.query.aluno.domain.model.AlunoRepository;
import com.cqrs.query.aluno.amqp.event.AlunoEvent;
import com.cqrs.query.aluno.domain.model.Aluno;
import com.cqrs.query.turma.domain.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
                .turmas(getTurmas(event))
                .build();

        repository.save(aluno);
    }

    private List<Turma> getTurmas(AlunoEvent event) {
        if (Objects.nonNull(event.getTurmas())) {
            return event.getTurmas().stream()
                    .map(id -> Turma.builder().id(id).build())
                    .collect(Collectors.toList());
        }
        return null;
    }
}
