package com.cqrs.query.aluno.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    private String id;

    private String nome;

    private Integer matricula;

    @Column(name = "formaingresso")
    private String formaIngresso;
}
