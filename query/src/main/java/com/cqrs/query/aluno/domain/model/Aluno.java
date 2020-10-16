package com.cqrs.query.aluno.domain.model;

import com.cqrs.query.turma.domain.model.Turma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "aluno_turma", joinColumns = {@JoinColumn(name = "aluno_id")}, inverseJoinColumns = {@JoinColumn(name = "turma_id")})
    private List<Turma> turmas;
}
