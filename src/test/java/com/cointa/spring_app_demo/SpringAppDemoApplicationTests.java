package com.cointa.spring_app_demo;


import com.cointa.spring_app_demo.School.SchoolRepository;
import com.cointa.spring_app_demo.Student.Student;
import com.cointa.spring_app_demo.Student.StudentRepository;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAppDemoApplicationTests {
        
        @Autowired
        private StudentRepository studenRepository;
        @Autowired
        private SchoolRepository schoolRepository;

	@Test
	void contextLoads() {
            
            //SOLO NOME STUDENTI
//            List<NameOnly> names= studenRepository.findBySchoolNameOnly();
//            for(NameOnly n: names){
//                System.out.println(n.getName());
//            }

            //SOLO NOME STUDENTI con solo nome scuole
            
//            NameOnly n = studenRepository.findById(1L);
//                System.out.println(n.getName()+" "+n.getSchool().getName());
            
        


	}

}
