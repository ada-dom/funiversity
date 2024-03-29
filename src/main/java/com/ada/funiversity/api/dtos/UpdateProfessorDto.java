package com.ada.funiversity.api.dtos;

public class UpdateProfessorDto {

    private String firstname;
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public UpdateProfessorDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UpdateProfessorDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
