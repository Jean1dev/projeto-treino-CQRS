package com.cqrs.core.turma.domain.repository;

import com.cqrs.core.turma.domain.model.Turma;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TurmaRepository extends MongoRepository<Turma, String> {
}
