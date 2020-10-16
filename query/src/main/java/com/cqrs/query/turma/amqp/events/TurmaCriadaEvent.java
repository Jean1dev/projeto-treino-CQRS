package com.cqrs.query.turma.amqp.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TurmaCriadaEvent {
    private String id;

    private String descricao;

    private Integer anoLetivo;

    private Integer periodoLetivo;

    private Integer numeroVagas;

    private Collection<String> alunos;

    private Collection<String> disciplinas;
}
