package com.cqrs.core.aluno.domain.repository;

import com.cqrs.core.aluno.domain.model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
