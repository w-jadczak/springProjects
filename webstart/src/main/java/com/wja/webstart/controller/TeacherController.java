package com.wja.webstart.controller;

import com.wja.webstart.model.Teacher;
import com.wja.webstart.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachersList(@RequestParam(required = false) List<String> subjects){
        return teacherService.getTeachersList(subjects);
    }

    @GetMapping("/teachers/{id}")
    public Teacher getCourse(@PathVariable("id") Long id){
        return teacherService.getTeacher(id);
    }

    @PostMapping("/teachers")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.createTeacher(teacher);
    }

    @PutMapping("/teachers")
    public void updateTeacher(@RequestBody Teacher teacher){
        teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/teachers")
    public void deleteTeacher(@RequestParam Long id){
        teacherService.deleteTeacher(id);
    }


}
