package com.cqrs.query.turma.domain.model;

import com.cqrs.query.aluno.domain.model.Aluno;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "turma")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Turma {

    @Id
    private String id;

    private String descricao;

    @Column(name = "anoletivo")
    private Integer anoLetivo;

    @Column(name = "periodoletivo")
    private Integer periodoLetivo;

    @Column(name = "numerovagas")
    private Integer numeroVagas;

    @ManyToMany(mappedBy = "turmas", fetch = FetchType.LAZY)
    private List<Aluno> alunos;
}
