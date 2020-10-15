package com.cqrs.core.turma.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection = "turmas")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Turma {

    @Id
    private String id;

    private String descricao;

    private Integer anoLetivo;

    private Integer periodoLetivo;

    private Integer numeroVagas;

    private Collection<String> alunos;

    private Collection<String> disciplinas;
}
