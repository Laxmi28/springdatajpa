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
    @Override
    public Student getStudentFromEmailId(String emailId) {
      return studentRepository.getStudentFromEmailAddress(emailId).orElse(null);
    }
    @Override
    public void deleteStudentById(long id) {
      if (studentRepository.existsById(id)){
          studentRepository.deleteById(id);
      }else{
         throw new RuntimeException("Student does not exists or is already deleted");
      }
    }
    @Override
    public Student updatedStudent(long id, Student student) {
      if(studentRepository.existsById(id)){
        Optional<Student> studentToBeUpadated = studentRepository.findById(id);
        Student studentStoredInDB = studentToBeUpadated.get();
        if(studentStoredInDB!=null){
           studentStoredInDB.setFirstName(student.getFirstName());
           studentStoredInDB.setLastName(student.getLastName());
           studentStoredInDB.setEmailId(student.getEmailId());
           studentRepository.save(studentStoredInDB);
           return studentStoredInDB;
        }
      }else{
        throw new RuntimeException("Student by this id does not exist");
      }
      return null;
    }
    @Override
    public Student partialStudentDetailsUpdate(long id, Student student) {
      if(studentRepository.existsById(id)){
        Optional<Student> studentToBeUpadated = studentRepository.findById(id);
        Student studentStoredInDB = studentToBeUpadated.get();
        if(studentStoredInDB!=null){
          if(student.getFirstName() != null){
            studentStoredInDB.setFirstName(student.getFirstName());
          } 

          if(student.getEmailId() != null){
            studentStoredInDB.setEmailId(student.getEmailId());
          }

          if(student.getLastName()!=null){
            studentStoredInDB.setEmailId(student.getEmailId()); 
          }
            
           studentRepository.save(studentStoredInDB);
           return studentStoredInDB;
        }
      }else{
        throw new RuntimeException("Student by this id does not exist");
      }
      return null;
    }
    @Override
    public Student updatedStudentNameById(long id,String firstName) {
      if(studentRepository.existsById(id)){
        Optional<Student> studentToBeUpadated = studentRepository.findById(id);
        Student studentStoredInDB = studentToBeUpadated.get();
        if(studentStoredInDB!=null){
           studentRepository.updateStudentNameFromId(id, firstName);
           studentRepository.save(studentStoredInDB);
           return studentStoredInDB;
        }
      }else{
        throw new RuntimeException("Student by this id does not exist");
      }
      return null;
    }

}
