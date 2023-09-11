package com.wja.webstart.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionTranslator {
    @ExceptionHandler(CourseNotFoundException.class)
   // @ResponseStatus(HttpStatus.NOT_FOUND)

    public String courseNotFoundHandler (CourseNotFoundException exception){
        return exception.getMessage();
    }
}
