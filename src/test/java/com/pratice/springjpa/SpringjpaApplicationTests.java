package com.pratice.springjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pratice.springjpa.Entity.Student;
import com.pratice.springjpa.Repository.StudentRepository;

@SpringBootTest
class SpringjpaApplicationTests {
    
    @Autowired
	private StudentRepository studentRepository;

	@Test
	private void save(){
		Student student = Student.builder().emailId("pranya01@gmail.com").name("Pranya Rathi").build();
		System.out.println("Inside test save ()");
		studentRepository.save(student);
		System.out.println("test save () executed");
	}

}
