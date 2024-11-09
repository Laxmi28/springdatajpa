package com.pratice.springjpa.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pratice.springjpa.Entity.CourseMaterial;

@Service
public interface CourseMaterialService {

    void saveCourse(CourseMaterial courseMaterial);

    List<CourseMaterial> getAllCourseMaterial();

}
