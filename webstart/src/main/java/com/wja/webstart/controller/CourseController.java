package com.wja.webstart.controller;

import com.wja.webstart.model.Course;
import com.wja.webstart.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Long id){
        return courseService.getCourse(id);
    }
}
