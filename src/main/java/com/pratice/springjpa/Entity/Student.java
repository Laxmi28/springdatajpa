package com.pratice.springjpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Student_tb_Student" ,
 uniqueConstraints = @UniqueConstraint(name="email_no_duplication_constraint",columnNames = "email_id"))

public class Student {
    
    @Id
    @SequenceGenerator(name = "student_seq",sequenceName = "student_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="student_seq")
    private long id;
    private String firstName;
    private String lastName;
    @Column(name = "email_id", nullable = false)
    private String emailId;


    

}
