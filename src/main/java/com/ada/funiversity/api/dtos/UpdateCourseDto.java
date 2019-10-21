package com.ada.funiversity.api.dtos;

public class UpdateCourseDto {

    private String name;
    private int studyPoints;
    private String professorId;

    public String getName() {
        return name;
    }

    public UpdateCourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public UpdateCourseDto setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public String getProfessorId() {
        return professorId;
    }

    public UpdateCourseDto setProfessorId(String professorId) {
        this.professorId = professorId;
        return this;
    }
}
