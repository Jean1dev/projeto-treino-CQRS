package com.cqrs.query.aluno.amqp.domain.repository;

import com.cqrs.query.aluno.domain.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
}
