package com.wja.webstart.service;

import com.wja.webstart.exception.CourseNotFoundException;
import com.wja.webstart.model.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Course> getCourses(List<String> category){
        return category != null ? courses.stream()
                .filter(course -> category.contains(course.getCategory()))
                .collect(Collectors.toList())
                : courses;
    }
    public Course getCourse(Long id){

        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new CourseNotFoundException(id));
    }

    public void createCourse(Course course){
        courses.add(course);
    }

    public void updateCourse(Course courseToUpdate){
        Long id = courseToUpdate.getId();

        courses.stream()
                .filter(course -> course.getId().equals(id))
                .findAny()
                .ifPresentOrElse(
                        c -> {
                            c.setAuthor(courseToUpdate.getAuthor());
                            c.setTitle(courseToUpdate.getTitle());
                            c.setCategory(courseToUpdate.getCategory());
                            c.setDescription(courseToUpdate.getDescription());
                        },
                        () -> {throw new CourseNotFoundException(id);}
                );
    }
}
