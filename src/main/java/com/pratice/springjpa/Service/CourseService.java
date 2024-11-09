package com.pratice.springjpa.Service;

import org.springframework.stereotype.Service;

import com.pratice.springjpa.Entity.Course;

@Service
public interface CourseService {

    void saveCourse(Course course);

}
