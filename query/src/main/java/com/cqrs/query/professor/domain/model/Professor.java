package com.cqrs.query.professor.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    private String id;

    private String nome;

    private String titulacao;
}
