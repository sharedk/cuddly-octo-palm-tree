package com.cointa.spring_app_demo;

import com.cointa.spring_app_demo.Student.Student;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringAppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppDemoApplication.class, args);
	}
}
