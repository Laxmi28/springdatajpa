package com.pratice.springjpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.springjpa.Entity.Teacher;
import com.pratice.springjpa.Service.TeacherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/teacher")
@Tag(name = "Teachers" , description = "post api")
public class TeacherController {
    
    @Autowired
    private TeacherService teacherService;
    
    @PostMapping("/saveTeacherDetails")
    @Operation(description="used to save teachers information")
    private ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
            teacherService.saveTeacher(teacher);
            return new ResponseEntity<>(HttpStatus.OK);

    }

}
