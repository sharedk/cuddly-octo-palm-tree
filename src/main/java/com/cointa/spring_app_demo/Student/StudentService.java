/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cointa.spring_app_demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cosimo
 */
@Service
public class StudentService {
    
    private StudentRepository studentRepository;
    
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public List<Student> getStudents(){
        return studentRepository.findAll();
                }

    void addStudent(Student student) throws IllegalAccessException {
        Optional<Student> optionalStudent= studentRepository.findStudentByMail(student.getEmail());
        if(optionalStudent.isPresent()) throw new IllegalAccessException("email already taken");
        studentRepository.save(student);
    }

    void deleteStudent(Long studentId) throws IllegalAccessException  {
        if(!studentRepository.existsById(studentId)) throw new IllegalAccessException("student with id " + studentId +" not found");
        studentRepository.deleteById(studentId);
    }
    
    @Transactional
    public void updateStudent(Long studentId,String name,String email) throws IllegalAccessException{
        Student student= studentRepository.findById(studentId).orElseThrow(
        ()-> new IllegalAccessException("student with id " + studentId +" not found"));
        
        if(!Objects.equals(name, student.getName()) && name !=null && name.length()>0) student.setName(name);
        if(!Objects.equals(email, student.getEmail()) && email !=null && email.length()>0){
            Optional<Student> studentOptional=studentRepository.findStudentByMail(email);
            if(studentOptional.isPresent()) throw new IllegalAccessException("email taken");
            student.setEmail(email);
        }
       
    }
    
}
