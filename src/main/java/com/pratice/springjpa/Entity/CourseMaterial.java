package com.pratice.springjpa.Entity;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
@Table(name = "Course_material",uniqueConstraints = @UniqueConstraint(name="course_Id_violation", columnNames = { "courseId" }))
public class CourseMaterial {
    
    @Id
    @SequenceGenerator(name = "CourseMaterialsq",sequenceName="CourseMaterialsq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "CourseMaterialsq")
    private Long courseMaterialId;
    @URL(message = "The provided url is not correct")
    private String courseUrl;
    @OneToOne (cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @JoinColumn( name = "course_Id",
    referencedColumnName = "courseId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Course course;

}
