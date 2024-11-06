package com.pratice.springjpa.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pratice.springjpa.Entity.Student;

@Service
public interface StudentService {

    void save(Student student);

    List<Student> getAllStudents();

    Optional<Student> findById(Long id);

    Optional<Student> findByFirstName(String name);

    Student getStudentFromIdAndLastName(long id, String lastName);

    Student getStudentFromEmailId(String emailId);

}
