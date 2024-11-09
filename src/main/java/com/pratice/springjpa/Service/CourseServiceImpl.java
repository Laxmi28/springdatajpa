package com.pratice.springjpa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.springjpa.Entity.Course;
import com.pratice.springjpa.Repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void saveCourse(Course course) {
      courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
      return courseRepository.findAll();
    }

}
