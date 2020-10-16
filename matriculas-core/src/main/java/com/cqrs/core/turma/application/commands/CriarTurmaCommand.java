package com.cqrs.core.turma.application.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CriarTurmaCommand {
    private String descricao;

    private Integer anoLetivo;

    private Integer periodoLetivo;

    private Integer numeroVagas;

    private Collection<String> alunos;

    private Collection<String> disciplinas;
}
