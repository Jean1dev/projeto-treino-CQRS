package com.cqrs.core.aluno.application;

import com.cqrs.core.aluno.application.commands.CriarAlunoCommand;
import com.cqrs.core.aluno.domain.model.Aluno;
import com.cqrs.core.aluno.domain.repository.AlunoRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoApplicationService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String criar(CriarAlunoCommand command) {
        Aluno aluno = Aluno.builder()
                .formaIngresso(command.getFormaIngresso())
                .matricula(command.getMatricula())
                .nome(command.getNome())
                .turmas(command.getTurmas())
                .build();

        Aluno save = repository.save(aluno);
        rabbitTemplate.convertAndSend("aluno-queue", save);

        return save.getId();
    }
}
