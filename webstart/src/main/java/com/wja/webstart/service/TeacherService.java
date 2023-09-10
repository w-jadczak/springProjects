package com.wja.webstart.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wja.webstart.model.Teacher;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service

public class TeacherService {


    private final List<Teacher> teachersList = new ArrayList<>();

    @PostConstruct

    public void initTeachers(){
        teachersList.add(new Teacher(
                1L,
                "Toby",
                "Flenderson",
                Arrays.asList("Math", "Science", "Biology"))
        );

        teachersList.add(new Teacher(
                2L,
                "Jim",
                "Henderson",
                Arrays.asList("English", "Phylosphy", "Biology"))
        );

        teachersList.add(new Teacher(
                3L,
                "Jane",
                "Austen",
                Arrays.asList("German", "Electronics", "Dance"))
        );
    }

    public List<Teacher> getTeachersList() {
        return teachersList;
    }

    public Teacher getTeacher(Long id){

        return teachersList.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst()
                .orElse(new Teacher());
    }
}
