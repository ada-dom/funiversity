package com.ada.funiversity.domain;

import java.util.Objects;
import java.util.UUID;

public class Professor {

    private final String id;
    private String firstname;
    private String lastname;

    public Professor(String firstname, String lastname) {
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void changeFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void changeLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id) &&
                Objects.equals(firstname, professor.firstname) &&
                Objects.equals(lastname, professor.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }
}
