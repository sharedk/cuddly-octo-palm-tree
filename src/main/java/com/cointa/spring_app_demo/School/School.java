/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cointa.spring_app_demo.School;

import com.cointa.spring_app_demo.Student.Student;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.transaction.Transactional;

/**
 *
 * @author cosimo
 */
@Entity
@Table
public class School {
    
    @Id
            @SequenceGenerator(
            name="school_sequence",
            sequenceName="school_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "school_sequence"
    
    )
    private Long id;
    private String name;
    
//    @OneToMany(mappedBy = "school",fetch = FetchType.LAZY)
//    private List<Student> students;

    public School(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public School(String name) {
        this.name = name;
    }

    public School() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }
}
