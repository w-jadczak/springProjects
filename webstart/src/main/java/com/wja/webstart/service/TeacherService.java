package com.wja.webstart.service;

import com.wja.webstart.exception.NonDifferentTeacherException;
import com.wja.webstart.exception.TeacherNotFoundException;
import com.wja.webstart.model.Teacher;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class TeacherService {


    private final List<Teacher> teachersList = new ArrayList<>();

    @Value("${myapp.softdelete.enabled}")
    private boolean softDeleteEnabled;
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

    public List<Teacher> getTeachersList(List<String> subjects) {
        return subjects != null ? teachersList.stream()
                .filter(teacher -> teacher.getSubjects().stream().anyMatch(t -> subjects.contains(t)))
                .collect(Collectors.toList()) : teachersList;
    }

    public Teacher getTeacher(Long id){

        if(softDeleteEnabled){
            throw new TeacherNotFoundException(id);
        }
        return teachersList.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst()
                .orElse(new Teacher());
    }

    public void createTeacher(Teacher teacher){
        teachersList.add(teacher);
    }

    public void updateTeacher(Teacher teacherToUpdate){
        Long id = teacherToUpdate.getId();

        teachersList.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findAny()
                .ifPresentOrElse(
                        t ->  {if(t.compareTo(teacherToUpdate) != 0){
                            t.setName(teacherToUpdate.getName());
                            t.setSurname(teacherToUpdate.getSurname());
                            t.setSubjects(teacherToUpdate.getSubjects());
                        }else{
                            throw new NonDifferentTeacherException(id);}
                        },
                        () -> {throw new TeacherNotFoundException(id);}
                );
    }

    public void deleteTeacher(Long id){
        teachersList.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findAny()
                .ifPresentOrElse(
                        t -> {if(softDeleteEnabled){
                            t.setDeleted(true);
                        }else{
                        teachersList.remove(t);}},
                        () -> {throw new TeacherNotFoundException(id);}
                );
    }


}
