package com.cqrs.query.professor.api;

import com.cqrs.query.professor.api.dto.ProfessorDto;
import com.cqrs.query.professor.domain.model.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @GetMapping("{id}")
    public ProfessorDto getOne(@PathVariable String id) {
        return ProfessorDto.objectToDto(repository.findById(id).get());
    }

    @GetMapping
    public List<ProfessorDto> getAll() {
        return ProfessorDto.collectionToDto(repository.findAll());
    }
}
