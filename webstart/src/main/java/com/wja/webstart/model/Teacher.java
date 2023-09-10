package com.wja.webstart.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Teacher {
    private Long id;

    private String name;
    private String surname;
    private List<String> subjects;

    public Teacher() {
    }

    public Teacher(Long id, String name, String surname, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subjects = subjects;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}
