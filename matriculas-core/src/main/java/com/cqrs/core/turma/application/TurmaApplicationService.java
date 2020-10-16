package com.cqrs.core.turma.application;

import com.cqrs.core.turma.application.commands.CriarTurmaCommand;
import com.cqrs.core.turma.domain.model.Turma;
import com.cqrs.core.turma.domain.repository.TurmaRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaApplicationService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TurmaRepository repository;

    public String criar(CriarTurmaCommand command) {
        Turma turma = Turma.builder()
                .alunos(command.getAlunos())
                .anoLetivo(command.getAnoLetivo())
                .descricao(command.getDescricao())
                .disciplinas(command.getDisciplinas())
                .numeroVagas(command.getNumeroVagas())
                .periodoLetivo(command.getPeriodoLetivo())
                .build();

        Turma save = repository.save(turma);
        rabbitTemplate.convertAndSend("turma-queue", save);

        return save.getId();
    }
}
