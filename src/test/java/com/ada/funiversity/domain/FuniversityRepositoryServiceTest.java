package com.ada.funiversity.domain;

import com.ada.funiversity.domain.repos.CoursesRepository;
import com.ada.funiversity.domain.repos.FuniversityRepositoryService;
import com.ada.funiversity.domain.repos.ProfessorsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FuniversityRepositoryServiceTest {

    private FuniversityRepositoryService funiversityRepositoryService;

    @BeforeEach
    void initiliaze() {
        funiversityRepositoryService = new FuniversityRepositoryService(new ProfessorsRepository(), new CoursesRepository());
    }

    @Test
    void save_givenAProfessorToSave_thenSavedProfessorIsEqualToProfessorToSave() {
        //given
        Professor professorToSave = new Professor("Ada", "Dom");
        //when
        Professor savedProfessor = funiversityRepositoryService.save(professorToSave);
        //then
        assertThat(professorToSave).isEqualTo(savedProfessor);
    }

    @Test
    void save_givenACourseToSavWithAnExistingProfessor_thenSavedCourseIsEqualToCourseToSave() {
        //given
        Professor existingProf = funiversityRepositoryService.save(new Professor("Alain", "Detaille"));
        Course courseToSave = new Course("Java", 6, existingProf.getId());
        //when
        Course savedCourse = funiversityRepositoryService.save(courseToSave);
        //then
        assertThat(courseToSave).isEqualTo(savedCourse);
    }

    @Test
    void save_givenACourseToSaveWithANotExistingProfessor_thenThrowAnIllegalArgumentException() {
        //given
        Course courseToSave = new Course("Java", 6, "1");

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            Course savedCourse = funiversityRepositoryService.save(courseToSave);
        });
    }

    //todo stubbing instead of save
    @Test
    void getById_givenSavedProfessors_thenReturnTheProfessorCorrespondingToId() {
        //given
        Professor professorToFind = funiversityRepositoryService.save(new Professor("Niels", "Delestinne"));
        funiversityRepositoryService.save(new Professor("Karel", "Switchfully"));
        //when
        Professor professorFound = funiversityRepositoryService.getProfessorById(professorToFind.getId());
        //then
        assertThat(professorFound).isEqualTo(professorToFind);
    }

    @Test
    void getById_givenNoProfessorForTheProvidedId_thenThrowIllegalArgumentException() {
        //given
        funiversityRepositoryService.save(new Professor("Alain", "Detaille"));

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            funiversityRepositoryService.getProfessorById(UUID.randomUUID().toString());
        });
    }

    @Test
    void getById_givenSavedCourses_thenReturnTheCourseCorrespondingToId() {
        //given
        Professor professor = funiversityRepositoryService.save(new Professor("Niels", "Delestinne"));
        Course courseToFind = funiversityRepositoryService.save(new Course("Java", 6, professor.getId()));
        funiversityRepositoryService.save(new Course("Maven", 4, professor.getId()));
        funiversityRepositoryService.save(new Course("Spring", 3, professor.getId()));
        //when
        Course courseFound = funiversityRepositoryService.getCourseById(courseToFind.getId());
        //then
        assertThat(courseFound).isEqualTo(courseToFind);
    }

    @Test
    void getById_givenNoCourseForTheProvidedId_thenThrowIllegalArgumentException() {
        //given
        Professor professor = funiversityRepositoryService.save(new Professor("Alain", "Detaille"));
        funiversityRepositoryService.save(new Course("DB", 4, professor.getId()));

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            funiversityRepositoryService.getCourseById(UUID.randomUUID().toString());
        });
    }
}