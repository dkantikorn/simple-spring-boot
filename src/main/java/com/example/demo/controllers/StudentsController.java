package com.example.demo.controllers;

import com.example.demo.services.StudentService;
import com.example.demo.model.student.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentsController {
    private final StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Students> getStudent() {
        return this.studentService.getStudent();
    }


//    @GetMapping("/student")
//    @GetMapping
//    public List<Student> getStudent(){
//        return List.of(
//                new Student(
//                        1L,
//                        "Sarawutt.b",
//                        "sarawutt.b@gmail.com",
//                        LocalDate.of(1986, Month.SEPTEMBER, 23),
//                        33),
//                new Student(
//                        2L,
//                        "Pogemon",
//                        "pogemon@gmail.com",
//                        LocalDate.of(2000,Month.JANUARY,01),
//                        21
//                )
//        );
//    }
}
