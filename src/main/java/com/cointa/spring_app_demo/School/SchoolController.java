/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cointa.spring_app_demo.School;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cosimo
 */
@RestController
@RequestMapping(path = "api/v1/schools")
public class SchoolController {
    
    private final SchoolService schoolService;
    
    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    
    @GetMapping
    public List<School> getSchools(){
        return schoolService.getSchools();
    }
    
    @GetMapping(path = "{id}")
    public School getSchoolById(@PathVariable("id") Long id) throws IllegalAccessException{
        return schoolService.getSchoolById(id);
    }
    
    
    
}
