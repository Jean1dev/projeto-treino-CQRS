package com.cqrs.query.turma.service;

import com.cqrs.query.aluno.domain.model.Aluno;
import com.cqrs.query.aluno.domain.model.AlunoRepository;
import com.cqrs.query.turma.amqp.events.TurmaCriadaEvent;
import com.cqrs.query.turma.domain.model.Turma;
import com.cqrs.query.turma.domain.model.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurmaCriadaService {

    @Autowired
    private TurmaRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    public void onCreated(TurmaCriadaEvent event) {
        Turma turma = Turma.builder()
                .id(event.getId())
                .descricao(event.getDescricao())
                .numeroVagas(event.getNumeroVagas())
                .periodoLetivo(event.getPeriodoLetivo())
                .anoLetivo(event.getAnoLetivo())
                .alunos(getAlunos(event))
                .build();

        repository.save(turma);
    }

    private List<Aluno> getAlunos(TurmaCriadaEvent event) {
        List<Aluno> list = new ArrayList<>();
        if (Objects.nonNull(event.getAlunos())) {
            return event.getAlunos().stream().map(id -> {
                Optional<Aluno> aluno = alunoRepository.findById(id);
                if (aluno.isPresent()) {
                    return aluno.get();
                }

                return null;
            }).collect(Collectors.toList());
        }
        return list;
    }
}
