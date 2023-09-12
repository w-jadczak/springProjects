package com.wja.webstart.exception;

public class NonDifferentTeacherException extends RuntimeException{
    public NonDifferentTeacherException(Long id){
        super("Teachers: " + id + " data are the same, can not update" );
    }
}
