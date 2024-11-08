package com.pratice.springjpa.Entity;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterial {
    
    @Id
    @SequenceGenerator(name = "CourseMaterialsq",sequenceName="CourseMaterialsq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "CourseMaterialsq")
    private Long courseMaterialId;
    @URL(message = "The provided url is not correct")
    private String courseUrl;

}
