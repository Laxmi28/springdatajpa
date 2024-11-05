package com.pratice.springjpa.Service;

import org.springframework.stereotype.Service;

import com.pratice.springjpa.Entity.Student;

@Service
public interface StudentService {

    void save(Student student);

}
