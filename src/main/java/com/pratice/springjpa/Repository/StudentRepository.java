package com.pratice.springjpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratice.springjpa.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}