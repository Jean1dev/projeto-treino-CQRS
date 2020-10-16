package com.cqrs.query.aluno.api.dto;

import com.cqrs.query.aluno.domain.model.Aluno;
import com.cqrs.query.turma.domain.model.Turma;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public final class AlunoDto {
    private String id;

    private String nome;

    private Integer matricula;

    private String formaIngresso;

    private List<TurmaAssosiacaoDto> turmas;

    public static AlunoDto objectoToDto(Aluno aluno) {
        return AlunoDto.builder()
                .id(aluno.getId())
                .formaIngresso(aluno.getFormaIngresso())
                .nome(aluno.getNome())
                .matricula(aluno.getMatricula())
                .turmas(criarTurmasAssociacao(aluno.getTurmas()))
                .build();
    }

    public static List<AlunoDto> collectionToDto(List<Aluno> alunos) {
        return alunos.stream().map(aluno -> {
            return AlunoDto.builder()
                    .id(aluno.getId())
                    .formaIngresso(aluno.getFormaIngresso())
                    .nome(aluno.getNome())
                    .matricula(aluno.getMatricula())
                    .turmas(criarTurmasAssociacao(aluno.getTurmas()))
                    .build();
        }).collect(Collectors.toList());
    }

    private static List<TurmaAssosiacaoDto> criarTurmasAssociacao(List<Turma> turmas) {
        return turmas.stream().map(turma ->
                TurmaAssosiacaoDto.builder()
                        .id(turma.getId())
                        .descricao(turma.getDescricao())
                        .build()).collect(Collectors.toList());
    }

    @Builder
    @Getter
    public static final class TurmaAssosiacaoDto {
        private String id;
        private String descricao;
    }
}
