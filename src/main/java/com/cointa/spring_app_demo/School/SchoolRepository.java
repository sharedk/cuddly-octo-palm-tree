/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cointa.spring_app_demo.School;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cosimo
 */
@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {
    
//    @Query("SELECT s FROM School s")
//    List<SchoolView> findAllSchoolView();
    
    List<NameOnly> findByNameLike(String s);
    
}
