package com.cqrs.core.professor.application;

import com.cqrs.core.professor.application.commands.CriarProfessorCommand;
import com.cqrs.core.professor.domain.model.Professor;
import com.cqrs.core.professor.domain.repository.ProfessorRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorApplicationService {

    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String criar(CriarProfessorCommand command) {
        Professor professor = Professor.builder()
                .nome(command.getNome())
                .titulacao(command.getTitulacao())
                .disciplinas(command.getDisciplinas())
                .build();

        Professor save = repository.save(professor);
        rabbitTemplate.convertAndSend("professor-queue", professor);

        return save.getId();
    }
}
