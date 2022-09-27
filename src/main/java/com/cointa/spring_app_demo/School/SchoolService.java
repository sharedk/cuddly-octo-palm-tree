/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cointa.spring_app_demo.School;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cosimo
 */
@Service
public class SchoolService {
    private SchoolRepository schoolRepository;
    
    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(Long id) throws IllegalAccessException {
        
        School school =schoolRepository.findById(id).orElseThrow(()-> new IllegalAccessException("school with id "+id+" not found"));
        return school;
    }
    
    
}
