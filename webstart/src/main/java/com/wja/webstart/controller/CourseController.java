package com.wja.webstart.controller;

import com.wja.webstart.model.Course;
import com.wja.webstart.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/courses")
    public List<Course> getCourses(@RequestParam(required = false) List<String> category){
        return courseService.getCourses(category);
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Long id){
        return courseService.getCourse(id);
    }
}
