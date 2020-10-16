package com.cqrs.core.professor.application.commands;

import com.cqrs.core.professor.domain.model.Titulacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashSet;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CriarProfessorCommand {
    private String nome;

    private Titulacao titulacao;

    private Collection<String> disciplinas = new HashSet<>();
}
