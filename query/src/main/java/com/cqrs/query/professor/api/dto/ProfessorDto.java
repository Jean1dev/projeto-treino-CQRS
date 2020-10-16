package com.cqrs.query.professor.api.dto;

import com.cqrs.query.professor.domain.model.Professor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public final class ProfessorDto {
    private String id;

    private String nome;

    private String titulacao;

    public static ProfessorDto objectToDto(Professor professor) {
        return ProfessorDto.builder()
                .id(professor.getId())
                .nome(professor.getNome())
                .titulacao(professor.getTitulacao())
                .build();
    }

    public static List<ProfessorDto> collectionToDto(List<Professor> professores) {
        return professores.stream().map(professor -> ProfessorDto.builder()
                .id(professor.getId())
                .nome(professor.getNome())
                .titulacao(professor.getTitulacao())
                .build()).collect(Collectors.toList());
    }
}
