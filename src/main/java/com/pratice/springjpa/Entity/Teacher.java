package com.pratice.springjpa.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "teacher_tb_teacher",uniqueConstraints = @UniqueConstraint(name = "teacherName_should_not_be_Same" ,
columnNames = { "teacherName" }))
public class Teacher {
   
    @Id
    @SequenceGenerator(name = "teacher_sq",sequenceName = "teacher_sq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_sq")
    private Long teacherId;
    private String teacherName;
    // @OneToMany(cascade = CascadeType.ALL,
    // fetch = FetchType.EAGER)
    // @JoinColumn(name = "teacher_ID", referencedColumnName = "teacherId" )
    // private Course course;
}
