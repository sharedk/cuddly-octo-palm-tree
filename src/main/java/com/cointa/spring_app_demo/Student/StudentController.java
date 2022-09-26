package com.cointa.spring_app_demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cosimo
 */
@RestController
@RequestMapping(path="api/v1/students")
public class StudentController {
    
    private final StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    
    @PostMapping
    public void addNewStudent(@RequestBody Student student) throws IllegalAccessException {
        studentService.addStudent(student);
    }
    
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) throws IllegalAccessException{
        studentService.deleteStudent(studentId);
    }
    
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String email) throws IllegalAccessException{
        studentService.updateStudent(studentId,name,email);
}
    
}
