package com.ada.funiversity.domain.repos;

import com.ada.funiversity.domain.Professor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProfessorsRepository {

    private final ConcurrentHashMap<String, Professor> professorsById;

    public ProfessorsRepository() {
        professorsById = new ConcurrentHashMap<>();
    }

    Professor save(Professor professorToSave) {
        professorsById.put(professorToSave.getId(), professorToSave);
        return professorToSave;
    }

    Professor getProfessorById(String id) {
        checkProfessorId(id);
        return professorsById.get(id);
    }

    private void checkProfessorId(String id) throws IllegalArgumentException {
        if (!isProfessorIdInRepository(id)) {
            throw new IllegalArgumentException("No Professor found for id: " + id);
        }
    }

    boolean isProfessorIdInRepository(String id) {
        return professorsById.containsKey(id);
    }

    Collection<Professor> getProfessors() {
        return professorsById.values();
    }

    Professor delete(String id) {
        checkProfessorId(id);
        return professorsById.remove(id);
    }
}
