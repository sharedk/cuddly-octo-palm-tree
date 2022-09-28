/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cointa.spring_app_demo.Student;

import com.cointa.spring_app_demo.School.NameOnly;
import com.cointa.spring_app_demo.School.School;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author cosimo
 */
public interface NameAndSchoolOnly {
    String getName();
    SchoolSummary getSchool(); 
    
    
    interface SchoolSummary{
        String getName();
    }
}
