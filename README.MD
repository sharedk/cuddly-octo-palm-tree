# Spring-App-Demo ![](https://img.shields.io/badge/spring--boot-v.2.7.4-orange) ![](https://img.shields.io/badge/spring--data--jpa-v.2.7.3-orange) ![](https://img.shields.io/badge/PostgreSQL-v14-orange)
The aim of this project is to illustrate basic functionalities of the [Spring-Boot](https://spring.io/projects/spring-boot) 
and [Spring-Data-Jpa](https://spring.io/projects/spring-data-jpa) projects. Any application property is set in the file [application.properties](https://github.com/sharedk/spring-demo-app/blob/master/src/main/resources/application.properties).
## Table of Contents:
* [Overall Structure](#Overall-Structure)
* [Interface Projections](#Interface-Projections)
* [Specifications](#Specifications)

### Overall Structure 
A local PostgreSQL database is required.

At Startup the application create a Student Table and a School Table in the database.
```java
@Entity 
 @Table 
 public class Student { 
 }
 ```
For Both Student and School classes a controller is defined to wich http requests are forwarded.
```java
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
}
```
The `List<Student>` object is automatically formatted in `json` and then returned in the response body.
Spring inject the istance of a Service in the controller and the service manage the requests through a Repository.
```java
@Service
public class StudentService {
    
    private StudentRepository studentRepository;
    private SchoolRepository schoolRepository;
    
    @Autowired
    public StudentService(StudentRepository studentRepository, SchoolRepository SchoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = SchoolRepository;
    }
    
    public List<Student> getStudents(){
        return studentRepository.findAll();
}

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
```
### Interface Projections
To get only some properties of entities projection interfaces and query-methods are used as described in [Spring Data JPA projections](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections)
and [Jpa query-methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)
```java
public interface NameAndSchoolOnly {
    String getName();
    SchoolSummary getSchool(); 
    
    
    interface SchoolSummary{
        String getName();
    }
}
```
Note that spring parses the method name in the interface to get the requested resource.
Additional Query method are defined in the repository class. If in the @Query value aliases are specified, make sure the method names match the aliases.
```java
    @Query(value = "SELECT student.name as name,school.name as schoolname FROM student LEFT JOIN school ON student.school_id=school.id", nativeQuery = true)
    List<NameAndSchoolOnly2> findAllCustomQuery();
    
    List<NameAndSchoolOnly> findByNameLike(String string);
```
### Specifications
Another way to get queries are Specifications as described in [Specifications](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#specifications).
In order to use specifications the repository class must extend `JpaSpecificationExecutorinterface<T>`. In this example the CustomSpec class contain static methods that return a custom Specification<T>
```java
public class CustomSpec{
    
    public static Specification<Student> bornBefore(LocalDate date){
        return (root,query,builder)->{
            return builder.lessThan(root.get("dob"),date);
        };
    }
```
Then a JpaSpecificationExecutor method can be called with the custom specification
```java
List<Student> students= studentRepository.findAll(CustomSpec.bornBefore(LocalDate.of(1994,Month.APRIL,1))
```
You would argue:""_Why not create a query method instead?"_, the power of specifications is that they can be combined. Say you have another specification
```java
public static Specification<Student> emailContains(String mailDomain){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("email"), "%"+mailDomain+"%"));
    }
```
Then you can combine theese two
```java
List<Student> students= studentRepository.findAll(CustomSpec.bornBefore(LocalDate.of(1994,Month.APRIL,1))
                    .or(CustomSpec.emailContains("outlook")));
```









