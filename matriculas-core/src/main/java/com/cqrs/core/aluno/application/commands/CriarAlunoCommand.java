package com.cqrs.core.aluno.application.commands;

import com.cqrs.core.aluno.domain.model.FormaIngresso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CriarAlunoCommand {
    private String nome;

    private Integer matricula;

    private FormaIngresso formaIngresso;

    private Collection<String> turmas;
}
