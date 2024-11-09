package com.pratice.springjpa.Service;

import org.springframework.stereotype.Service;

import com.pratice.springjpa.Entity.Course;
import com.pratice.springjpa.Repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Override
    public void saveCourse(Course course) {
      courseRepository.save(course);
    }

}
