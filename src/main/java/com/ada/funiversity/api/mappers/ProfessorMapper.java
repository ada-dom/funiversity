package com.ada.funiversity.api.mappers;

import com.ada.funiversity.api.dtos.ProfessorDto;
import com.ada.funiversity.domain.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public ProfessorDto mapToDto(Professor professor) {
        return new ProfessorDto()
                .setId(professor.getId())
                .setFirstname(professor.getFirstname())
                .setLastname(professor.getLastname());
    }
}
