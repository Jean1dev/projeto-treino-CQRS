package com.cqrs.query.professor.amqp.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorCriadoEvent {
    private String id;

    private String nome;

    private String titulacao;

    private Collection<String> disciplinas;
}
