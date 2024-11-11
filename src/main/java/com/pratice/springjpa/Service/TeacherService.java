package com.pratice.springjpa.Service;

import org.springframework.stereotype.Service;

import com.pratice.springjpa.Entity.Teacher;

@Service
public interface TeacherService {

    void saveTeacher(Teacher teacher);

}
