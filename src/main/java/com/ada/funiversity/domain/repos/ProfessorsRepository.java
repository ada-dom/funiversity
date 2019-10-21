package com.ada.funiversity.domain.repos;

import com.ada.funiversity.domain.Professor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProfessorsRepository {

    private final ConcurrentHashMap<String, Professor> professorsById;

    public ProfessorsRepository() {
        professorsById = new ConcurrentHashMap<>();
    }

    public Professor save(Professor professorToSave) {
        professorsById.put(professorToSave.getId(), professorToSave);
        return professorToSave;
    }

    public Professor getProfessorById(String id) {
        if(!isProfessorIdInRepository(id)) {
            throw new IllegalArgumentException("No Professor found for id: " + id);
        }
        return professorsById.get(id);
    }

    protected boolean isProfessorIdInRepository(String id) {
        return professorsById.containsKey(id);
    }
}
