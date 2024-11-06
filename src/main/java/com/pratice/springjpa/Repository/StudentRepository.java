package com.pratice.springjpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratice.springjpa.Entity.Student;

import jakarta.transaction.Transactional;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    
    Optional<Student>  findByFirstName(String firstName);
    
    //JPQL query 
    @Query("select s from Student s where s.id = ?1 and s.lastName = ?2")
    Optional<Student> getStudentByIdandLastName(long id , String lastName);

    //native query
    @Query(value = "select * from student_tb_student s where s.email_id = ?1",nativeQuery = true)
    Optional<Student> getStudentFromEmailAddress(String email_id);
    
    @Modifying
    @Transactional
    @Query(value = "update student_tb_student s set s.first_name =  :name where s.id =  :id",nativeQuery =true )
    int updateStudentNameFromId(@Param("id")long id , @Param("name") String name);
}
