package com.pratice.springjpa.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.springjpa.Entity.Student;
import com.pratice.springjpa.Service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




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
    
    @GetMapping("/fetchAllStudents")
    private List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    
    @GetMapping("/findStudentById/{id}")
    private ResponseEntity<Student> findById(@PathVariable Long id){
        Optional<Student> fetchedStudent = studentService.findById(id);
        if(fetchedStudent.get() != null){
          return new ResponseEntity<>(fetchedStudent.get(),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
