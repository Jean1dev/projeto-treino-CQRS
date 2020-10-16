package com.cqrs.core.professor.domain.repository;

import com.cqrs.core.professor.domain.model.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessorRepository extends MongoRepository<Professor, String> {
}
