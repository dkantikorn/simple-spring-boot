package com.example.demo.controllers;

import com.example.demo.services.StudentService;
import com.example.demo.model.student.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerNewStudent(@RequestBody Students student) {
        this.studentService.registerNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudentById(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        studentService.updateStudent(studentId, name, email);
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
