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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    
    @GetMapping("/studentsFetchedByFirstName/{name}")
    private ResponseEntity<Student> findByFirstName(@PathVariable String name){
        Optional<Student> fetchedStudent = studentService.findByFirstName(name);
        if(fetchedStudent.get() != null){
          return new ResponseEntity<>(fetchedStudent.get(),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   @GetMapping("/FindStudentAsPerLNameAndId/{id}/{lastName}") 
   private ResponseEntity<Student> getStudentFromIdAndLastName(@PathVariable long id , @PathVariable String lastName){
    Student fetchedStudent = studentService.getStudentFromIdAndLastName(id,lastName);
    if(fetchedStudent != null){
      return new ResponseEntity<>(fetchedStudent,HttpStatus.FOUND);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   
   @GetMapping("/StudentAsPerEmail/{emailId}")
   private ResponseEntity<Student> getStudentFromEmalId(@PathVariable String emailId){
    Student fetchedStudent = studentService.getStudentFromEmailId(emailId);
    if(fetchedStudent != null){
      return new ResponseEntity<>(fetchedStudent,HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @PutMapping("/updateStudentDetails/{id}")
    private ResponseEntity<Student> updateStudentDetails(@PathVariable long id , @RequestBody Student student){
      try{
        Student updatedStudent = studentService.updatedStudent(id,student);
        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
      }catch (RuntimeException exception){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    
    }   
      
   @PatchMapping("/partialStudentUpdate/{id}")
   private ResponseEntity<Student>  partialStudentDetailsUpdate(@PathVariable long id , @RequestBody Student student) {
    try{
      Student partialUpdatedStudent = studentService.partialStudentDetailsUpdate(id,student);
      return new ResponseEntity<>(partialUpdatedStudent,HttpStatus.OK);
    }catch (RuntimeException exception){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  

   }
   
   @DeleteMapping("/removeStudent/{id}")
   private ResponseEntity<Student> deleteStudentById(@PathVariable long id){
    try{
      studentService.deleteStudentById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }catch (RuntimeException exception){
      System.err.println(exception);
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    
   }
   
}
