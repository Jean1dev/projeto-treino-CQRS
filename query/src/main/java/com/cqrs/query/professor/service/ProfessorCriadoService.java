package com.cqrs.query.professor.service;

import com.cqrs.query.professor.amqp.events.ProfessorCriadoEvent;
import com.cqrs.query.professor.domain.model.Professor;
import com.cqrs.query.professor.domain.model.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorCriadoService {

    @Autowired
    private ProfessorRepository repository;

    public void onCreated(ProfessorCriadoEvent event) {
        Professor professor = Professor.builder()
                .id(event.getId())
                .nome(event.getNome())
                .titulacao(event.getTitulacao())
                .build();

        repository.save(professor);
    }
}
