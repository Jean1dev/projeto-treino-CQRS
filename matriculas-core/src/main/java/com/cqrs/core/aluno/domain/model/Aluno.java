package com.cqrs.core.aluno.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection = "alunos")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    private String id;

    private String nome;

    private Integer matricula;

    private FormaIngresso formaIngresso;

    private Collection<String> turmas;
}
