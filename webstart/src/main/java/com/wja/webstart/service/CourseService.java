package com.wja.webstart.service;

import com.wja.webstart.model.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final List<Course> courses = new ArrayList<>();


    @PostConstruct
    public void initCourses(){
        courses.add(new Course(
                1L,
                "Git basics",
                "John",
                "Tools",
                "Basics of GIT version control")
        );

        courses.add(new Course(
                2L,
                "Java concurrency",
                "Marc",
                "Programming",
                "Java multithreading and concurrency")
        );

        courses.add(new Course(
                3L,
                "SQL procedures",
                "Steven",
                "Programming",
                "Writing performant procedures in SQL")
        );
    }

    public List<Course> getCourses(){
        return courses;
    }

    public Course getCourse(Long id){

        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElse(new Course());
    }
}
