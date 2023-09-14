package com.wja.webstart.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Teacher implements Comparable<Teacher>{
    private Long id;
    @NotBlank(message = "Name can not be blank")
    private String name;
    @NotBlank(message = "Surname can not be blank")
    private String surname;
    @NotNull(message = "Subjects list can not be empty")
    private List<String> subjects;
    private Boolean deleted;

    public Teacher() {
    }

    public Teacher(Long id, String name, String surname, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subjects = subjects;
        this.deleted = false;
    }

    @Override
    public int compareTo(Teacher teacher2) {
        if (!this.name.equals(teacher2.name)) return -1;
        if (!this.surname.equals(teacher2.getSurname())) return -1;
        if(!this.subjects.equals(teacher2.subjects)) return -1;
        return 0;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
