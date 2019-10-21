package com.ada.funiversity.api.dtos;

public class CreateCourseDto {

    private String name;
    private int studyPoints;
    private String professorId;

    public String getName() {
        return name;
    }

    public CreateCourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public CreateCourseDto setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public String getProfessorId() {
        return professorId;
    }

    public CreateCourseDto setProfessorId(String professorId) {
        this.professorId = professorId;
        return this;
    }
}
