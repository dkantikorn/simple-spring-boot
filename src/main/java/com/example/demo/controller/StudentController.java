package com.example.demo.controller;

import com.example.demo.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
//    @GetMapping("/student")
    @GetMapping
    public List<Student> getStudent(){
        return List.of(
                new Student(
                        1L,
                        "Sarawutt.b",
                        "sarawutt.b@gmail.com",
                        LocalDate.of(1986, Month.SEPTEMBER, 23),
                        33),
                new Student(
                        2L,
                        "Pogemon",
                        "pogemon@gmail.com",
                        LocalDate.of(2000,Month.JANUARY,01),
                        21
                )
        );
    }
}
