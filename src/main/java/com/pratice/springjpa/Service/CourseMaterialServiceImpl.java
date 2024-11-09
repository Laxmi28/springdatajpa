package com.pratice.springjpa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.springjpa.Entity.CourseMaterial;
import com.pratice.springjpa.Repository.CourseMaterialRepository;


@Service
public class CourseMaterialServiceImpl  implements CourseMaterialService{
    
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Override
    public void saveCourse(CourseMaterial courseMaterial) {
        courseMaterialRepository.save(courseMaterial);
    }

    @Override
    public List<CourseMaterial> getAllCourseMaterial() {
         return  courseMaterialRepository.findAll();
    }

}
