package com.pratice.springjpa.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.springjpa.Entity.Course;
import com.pratice.springjpa.Service.CourseService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/course")
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    @PostMapping("/createCourse")
     private ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course){
        try{
            courseService.saveCourse(course);
            return new ResponseEntity<>(course,HttpStatus.OK);
        }catch (Exception exception){
             System.err.println(exception);
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
         
        
    }

}
