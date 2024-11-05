package com.pratice.springjpa.Entity;

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
 uniqueConstraints = @UniqueConstraint(name="email_no_duplication_constraint",columnNames = "emailId"))

public class Student {
    
    @Id
    @SequenceGenerator(name = "student_seq",sequenceName = "student_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="student_seq")
    private long id;
    private String name;

    private String emailId;
    

}
