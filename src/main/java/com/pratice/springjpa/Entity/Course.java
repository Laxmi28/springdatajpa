package com.pratice.springjpa.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    
    @Id
    @SequenceGenerator(name = "courseSq",sequenceName = "courseSq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "courseSq")
    private Long courseId;
    @Min(value = 1 ,message = "The course can have minimum credit of 1")
    @Max(value = 10,message = "The course credit cannot exceed more the 10 value")
    private int credits;
    @NotBlank(message = "The course name can never be blank")
    @NotNull(message = "The course name can never be null")
    private String courseName;
}
