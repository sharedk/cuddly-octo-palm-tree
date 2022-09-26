/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cointa.spring_app_demo.Student;

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
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandlineRunner(StudentRepository studentRepository){
        return args -> {
            Student cosimo = new Student("cosimo", LocalDate.of(1995,Month.DECEMBER,27), "cosimo.moretti@outlook.it");
            Student mariam = new Student("mariam",LocalDate.of(1995,Month.APRIL,8),"mariam@gmail.com");
            List<Student> studentList =Arrays.asList(mariam,cosimo);
            studentRepository.saveAll(studentList);
        };
    }
    
}
