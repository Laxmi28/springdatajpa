package com.pratice.springjpa.Service;

import java.util.List;
import java.util.Optional;

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
    @Override
    public List<Student> getAllStudents() {
      return studentRepository.findAll();
    }
    @Override
    public Optional<Student> findById(Long id) {
      return studentRepository.findById(id);
    }
    @Override
    public Optional<Student> findByFirstName(String name) {
      return studentRepository.findByFirstName(name);
    }
    @Override
    public Student getStudentFromIdAndLastName(long id, String lastName) {
      return studentRepository.getStudentByIdandLastName(id, lastName).orElse(null);
    }

}
