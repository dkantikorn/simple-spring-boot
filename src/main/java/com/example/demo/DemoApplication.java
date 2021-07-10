package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String welcomePage(){
		return "Welcome to Spring Boot";
	}

//	@GetMapping
//	public String hello(){
//		return "Hello Sarawutt";
//	}

//	@GetMapping
//	public List<String> hello(){
//		return List.of("Hello World","Sarawutt");
//	}
}
