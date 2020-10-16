package com.cqrs.query.aluno.api;

import com.cqrs.query.aluno.api.dto.AlunoDto;
import com.cqrs.query.aluno.domain.model.Aluno;
import com.cqrs.query.aluno.domain.model.AlunoRepository;
import com.cqrs.query.aluno.exceptions.AlunoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping("{id}")
    public AlunoDto getOne(@PathVariable String id) {
        Optional<Aluno> aluno = repository.findById(id);
        if (aluno.isPresent())
            return AlunoDto.objectoToDto(aluno.get());

        throw new AlunoNotFoundException();
    }

    @GetMapping
    public List<AlunoDto> getAll() {
        return AlunoDto.collectionToDto(repository.findAll());
    }
}
