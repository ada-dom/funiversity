package com.ada.funiversity.domain;

import java.util.UUID;

public class Course {

    private static final int MIN_STUDY_POINTS = 1;
    private static final int MAX_STUDY_POINTS = 6;

    private final String id;
    private String name;
    private int studyPoints;
    private String professorId;

    public Course(String name, int studyPoints, String professorId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.studyPoints = validateStudyPointsRange(studyPoints);
        this.professorId = professorId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public String getProfessorId() {
        return professorId;
    }

    private int validateStudyPointsRange(int studyPoints) {
        if(studyPoints < MIN_STUDY_POINTS || studyPoints > MAX_STUDY_POINTS) {
            throw new IllegalArgumentException("Study points should be between "
            + MIN_STUDY_POINTS + " and " + MAX_STUDY_POINTS + ", for course of id: " + id);
        }
        return studyPoints;
    }
}
