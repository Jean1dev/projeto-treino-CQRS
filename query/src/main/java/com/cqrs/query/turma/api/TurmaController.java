package com.cqrs.query.turma.api;

import com.cqrs.query.turma.api.dto.TurmaDto;
import com.cqrs.query.turma.domain.model.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @GetMapping
    public List<TurmaDto> findAll() {
        return TurmaDto.collectionToDto(repository.findAll());
    }

    @GetMapping("{id}")
    public TurmaDto getOne(@PathVariable String id) {
        return TurmaDto.objectoToDto(repository.findById(id).get());
    }
}
