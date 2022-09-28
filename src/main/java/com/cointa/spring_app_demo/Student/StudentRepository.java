/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cointa.spring_app_demo.Student;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cosimo
 * 
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    
    @Query("SELECT s FROM Student s where s.email=?1")
    Optional<Student> findStudentByMail(String email);
    
    @Query("SELECT name FROM Student s")
    List<String> findNames();
    
    @Query(value = "SELECT student.name as A,school.name as B FROM student LEFT JOIN school ON student.school_id=school.id WHERE student.name LIKE ?1", nativeQuery = true)
    List<NameAndSchoolOnly2> findByNameLikeCustomQuery(String string);
    
    List<NameAndSchoolOnly> findByNameLike(String string);
     
}
