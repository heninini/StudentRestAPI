package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    //    handel exception using @Exceptionhandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//        create the response
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
//        return the response
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    //    handling all exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
//        return the response
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}