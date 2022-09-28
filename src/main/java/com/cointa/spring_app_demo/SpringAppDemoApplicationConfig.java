package com.cointa.spring_app_demo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.cointa.spring_app_demo.School.School;
import com.cointa.spring_app_demo.School.SchoolRepository;
import com.cointa.spring_app_demo.Student.Student;
import com.cointa.spring_app_demo.Student.StudentRepository;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author cosimo
 */

@Configuration
public class SpringAppDemoApplicationConfig {
    
    @Bean
    CommandLineRunner commandlineRunner(StudentRepository studentRepository,SchoolRepository schoolRepository){
        return args -> {
            School school1= new School("LiceoFasano");
            schoolRepository.save(school1);
            Student cosimo = new Student("cosimo","moretti",LocalDate.of(1995,Month.DECEMBER,27), "cosimo.moretti@outlook.it",school1);
            Student mariam = new Student("mariam","jhamal",LocalDate.of(1995,Month.APRIL,8),"mariam@gmail.com",school1);
            List<Student> studentList =Arrays.asList(mariam,cosimo);
            studentRepository.saveAll(studentList);
            
        };
    }
    
    
    
}
