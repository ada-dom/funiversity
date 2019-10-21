package com.ada.funiversity.api;

import com.ada.funiversity.domain.repos.FuniversityRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/professors")
@ComponentScan("com.ada.fununiversity")
public class ProfessorController {

    private FuniversityRepositoryService funiversityRepositoryService;

    @Autowired
    public ProfessorController(FuniversityRepositoryService funiversityRepositoryService) {
        this.funiversityRepositoryService = funiversityRepositoryService;
    }
}
