package com.pratice.springjpa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.springjpa.Entity.CourseMaterial;
import com.pratice.springjpa.Service.CourseMaterialService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/coursematerial")
@Tag(name= "Courses Material" , description = "post and get api")
public class CourseMaterialController {

    @Autowired
    private CourseMaterialService courseMaterialService;
    
    @PostMapping("/createCourse")
     private ResponseEntity<CourseMaterial> saveCourse(@Valid @RequestBody CourseMaterial courseMaterial){
        try{
            courseMaterialService.saveCourse(courseMaterial);
            return new ResponseEntity<>(courseMaterial,HttpStatus.OK);
        }catch (Exception exception){
             System.err.println(exception);
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
    }  

    @GetMapping("/FindAllCourseMaterial")
    private ResponseEntity<List<CourseMaterial>> getAllCourseMaterial(){
      List<CourseMaterial> courseMaterials =  courseMaterialService.getAllCourseMaterial();
      return new ResponseEntity<>(courseMaterials,HttpStatus.OK);

    }
    

}
