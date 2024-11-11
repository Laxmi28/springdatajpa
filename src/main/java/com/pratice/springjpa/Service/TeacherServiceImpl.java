package com.pratice.springjpa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.springjpa.Entity.Teacher;
import com.pratice.springjpa.Repository.TeacherRespository;
@Service
public class TeacherServiceImpl implements TeacherService {
    
    @Autowired
    private TeacherRespository teacherRespository;
    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRespository.save(teacher);
    }

}
