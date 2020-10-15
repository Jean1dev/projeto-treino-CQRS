package com.cqrs.query.aluno.amqp.event;

import lombok.*;

import java.util.Collection;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoEvent {
    private String id;

    private String nome;

    private Integer matricula;

    private String formaIngresso;

    private Collection<String> turmas;
}
