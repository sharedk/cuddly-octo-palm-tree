/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cointa.spring_app_demo.Student;

import java.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;


/**
 *
 * @author cosimo
 */
public class CustomSpec{
    
    public static Specification<Student> bornBefore(LocalDate date){
        return (root,query,builder)->{
            return builder.lessThan(root.get("dob"),date);
        };
    }
    
    public static Specification<Student> emailContains(String mailDomain){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("email"), "%"+mailDomain+"%"));
    }
    
}
