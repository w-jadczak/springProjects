package com.wja.webstart.controller;

import com.wja.webstart.model.Teacher;
import com.wja.webstart.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachersList(){
        return teacherService.getTeachersList();
    }

    @GetMapping("/teachers/{id}")
    public Teacher getCourse(@PathVariable("id") Long id){
        return teacherService.getTeacher(id);
    }
}
