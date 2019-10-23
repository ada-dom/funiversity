package com.ada.funiversity.domain.repos;

import com.ada.funiversity.domain.Course;
import com.ada.funiversity.domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class FuniversityRepositoryService {


    private final ProfessorsRepository professorsRepository;
    private final CoursesRepository coursesRepository;

    @Autowired
    public FuniversityRepositoryService(ProfessorsRepository professorsRepository, CoursesRepository coursesRepository) {
        this.professorsRepository = professorsRepository;
        this.coursesRepository = coursesRepository;
    }

    public Professor save(Professor professorToSave) {
        return professorsRepository.save(professorToSave);
    }

    public Course save(Course courseToSave) {
        if(!professorsRepository.isProfessorIdInRepository(courseToSave.getProfessorId())) {
            throw new IllegalArgumentException("You can't add a course with a not existing professor.");
        }
        return coursesRepository.save(courseToSave);
    }

    public Professor getProfessorById(String id) {
        return professorsRepository.getProfessorById(id);
    }

    public Course getCourseById(String id) {
        return coursesRepository.getCourseById(id);
    }

    public Collection<Professor> getProfessors() {
        return professorsRepository.getProfessors();
    }

    public Collection<Course> getCourses(int studyPointsFilter) {
        return coursesRepository.getCourses(studyPointsFilter);
    }

    public Professor delete(String id) {
        return professorsRepository.delete(id);
    }
}
