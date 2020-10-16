package com.cqrs.query.turma.api.dto;

import com.cqrs.query.aluno.domain.model.Aluno;
import com.cqrs.query.turma.domain.model.Turma;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public final class TurmaDto {
    private String id;

    private String descricao;

    private Integer anoLetivo;

    private Integer periodoLetivo;

    private Integer numeroVagas;

    private List<AlunoAssociacaoDto> alunos;

    public static TurmaDto objectoToDto(Turma turma) {
        return TurmaDto.builder()
                .id(turma.getId())
                .descricao(turma.getDescricao())
                .anoLetivo(turma.getAnoLetivo())
                .periodoLetivo(turma.getPeriodoLetivo())
                .numeroVagas(turma.getNumeroVagas())
                .alunos(convert(turma.getAlunos()))
                .build();
    }

    public static List<TurmaDto> collectionToDto(List<Turma> turmas) {
        return turmas.stream().map(turma -> TurmaDto.builder()
                .id(turma.getId())
                .descricao(turma.getDescricao())
                .anoLetivo(turma.getAnoLetivo())
                .periodoLetivo(turma.getPeriodoLetivo())
                .numeroVagas(turma.getNumeroVagas())
                .alunos(convert(turma.getAlunos()))
                .build()).collect(Collectors.toList());
    }

    private static List<AlunoAssociacaoDto> convert(List<Aluno> alunos) {
        return alunos.stream().map(aluno -> AlunoAssociacaoDto.builder()
                .id(aluno.getId())
                .nome(aluno.getNome())
                .build()).collect(Collectors.toList());
    }

    @Builder
    @Getter
    public static class AlunoAssociacaoDto {
        private String id;
        private String nome;
    }
}
