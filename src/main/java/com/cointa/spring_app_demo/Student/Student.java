/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cointa.spring_app_demo.Student;

import com.cointa.spring_app_demo.School.School;
import java.time.LocalDate;
import java.time.Period;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author cosimo
 */
@Entity
@Table
public class Student {
    
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName="student_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    
    )
    private Long id;
    private String name;
    //@Column(columnDefinition = "varchar(255) default ''")
    private String surname;
    @Transient
    private Integer age;
    private LocalDate dob;
    
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }
    private String email;

    public Student() {
    }

    public Student(Long id, String name,String surname,  LocalDate dob, String email,School school) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.email = email;
        this.school= school;
    }

    public Student(String name,String surname, LocalDate dob, String email,School school) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.email = email;
        this.school= school;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + ", email=" + email + '}';
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public School
         getSchool() {
        return this.school;
//        if(this.school!=null) return this.school.getId();
//        else return null;
        
    }
        
    
    
}
