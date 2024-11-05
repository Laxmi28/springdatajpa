package com.pratice.springjpa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.springjpa.Entity.Student;
import com.pratice.springjpa.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
   @Autowired
    private StudentRepository studentRepository;
    @Override
    public void save(Student student) {
      studentRepository.save(student);
    }

}
