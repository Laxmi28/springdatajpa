package com.pratice.springjpa.Exceptionhadling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pratice.springjpa.ErrorResponse.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionhandler {
    
    @ExceptionHandler(StudentNotFoundException.class)
    private ResponseEntity<?>  handleStudentNotFoundException(StudentNotFoundException exception){
        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(),exception.getMessage()), HttpStatus.NOT_FOUND);
    } 

    

}
