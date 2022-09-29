package com.cointa.spring_app_demo;


import com.cointa.spring_app_demo.School.NameOnly;
import com.cointa.spring_app_demo.School.SchoolRepository;
import com.cointa.spring_app_demo.Student.CustomSpec;
import com.cointa.spring_app_demo.Student.NameAndSchoolOnly;
import com.cointa.spring_app_demo.Student.NameAndSchoolOnly2;
import com.cointa.spring_app_demo.Student.Student;
import com.cointa.spring_app_demo.Student.StudentRepository;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAppDemoApplicationTests {
        
        @Autowired
        private StudentRepository studentRepository;
        @Autowired
        private SchoolRepository schoolRepository;

	@Test
	void ByNameLikeLeftJoinWithNameAndSchoolOnlyInterfaceProjection() {
            
            //LEFT JOIN ON STUDENT_SCHOOL_ID=SCHOOL_ID ATTRAVERSO NAMEANDSCHOOLONLY INTERFACE PROJECTION AND QUERY-METHOD
            List<NameAndSchoolOnly> students=studentRepository.findByNameLike("%%");
            for(NameAndSchoolOnly student: students){
                System.out.println(student.getName()+" "+student.getSchool().getName());
            }

	}
        
        @Test
        void ByNameLikeLeftJoinWithNameAndSchoolOnly2InterfaceProjectionAndCustomQuery(){
            List<NameAndSchoolOnly2> students=studentRepository.findAllCustomQuery();
            for(NameAndSchoolOnly2 student: students){
                System.out.println(student.getName()+" "+student.getSchoolname());
            }  
        } 
        @Test
        void TestSpecifications(){
            List<Student> students= studentRepository.findAll(CustomSpec.bornBefore(LocalDate.of(1994,Month.APRIL,1))
                    .or(CustomSpec.emailContains("outlook")));
            for(Student student:students){
                System.out.println(student.getName()+" "+student.getSchool().getName());
            }
        }
}