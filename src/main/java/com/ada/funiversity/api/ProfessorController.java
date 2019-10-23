package com.ada.funiversity.api;

import com.ada.funiversity.api.dtos.CreateProfessorDto;
import com.ada.funiversity.api.dtos.ProfessorDto;
import com.ada.funiversity.api.dtos.UpdateProfessorDto;
import com.ada.funiversity.api.mappers.ProfessorMapper;
import com.ada.funiversity.domain.Professor;
import com.ada.funiversity.domain.repos.FuniversityRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path= "/professors")
@ComponentScan("com.ada.fununiversity")
public class ProfessorController {

    public static final String APPLICATION_JSON = "application/json";
    private FuniversityRepositoryService funiversityRepositoryService;
    private ProfessorMapper professorMapper;

    @Autowired
    public ProfessorController(FuniversityRepositoryService funiversityRepositoryService,
                               ProfessorMapper professorMapper) {
        this.funiversityRepositoryService = funiversityRepositoryService;
        this.professorMapper = professorMapper;
    }


    @PostMapping(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDto createProfessor(CreateProfessorDto createProfessorDto) {
        return professorMapper.mapToDto(
                new Professor(createProfessorDto.getFirstname(), createProfessorDto.getLastname()));
    }

    @GetMapping(produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDto> getProfessors() {
        return funiversityRepositoryService
                .getProfessors()
                .stream()
                .map(professor -> this.professorMapper.mapToDto(professor))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto getProfessor(@PathVariable("id") String id) {
        return professorMapper.mapToDto(funiversityRepositoryService.getProfessorById(id));
    }

    @PutMapping(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto updateProfessor(@PathVariable("id") String id,
                                        @RequestBody UpdateProfessorDto updateProfessorDto) {
        Professor profToUpdate = funiversityRepositoryService.getProfessorById(id);
        profToUpdate.changeFirstname(updateProfessorDto.getFirstname());
        profToUpdate.changeLastname(updateProfessorDto.getLastname());
        return professorMapper.mapToDto(profToUpdate);
    }

    @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON)
    public ProfessorDto deleteProfessor(@PathVariable("id") String id) {
        return professorMapper.mapToDto(funiversityRepositoryService.delete(id));
    }
}
