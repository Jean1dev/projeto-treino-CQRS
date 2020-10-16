package com.cqrs.core.professor.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.HashSet;

@Document(collection = "professores")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    private String id;

    private String nome;

    private Titulacao titulacao;

    private Collection<String> disciplinas = new HashSet<>();
}
