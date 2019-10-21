package com.ada.funiversity.api.dtos;

public class ProfessorDto {
    private String id;
    private String firstname;
    private String lastname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public ProfessorDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public ProfessorDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
