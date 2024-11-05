package com.pratice.springjpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.springjpa.Entity.Student;
import com.pratice.springjpa.Service.StudentService;
import com.pratice.springjpa.Service.StudentServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/student/")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @PostMapping("/createStudent")
    private ResponseEntity<Student> createStudent(@RequestBody Student student){
        studentService.save(student);
        return  new ResponseEntity<>(student,HttpStatus.CREATED);
    }

}
