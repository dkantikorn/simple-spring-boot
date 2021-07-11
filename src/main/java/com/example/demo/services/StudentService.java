package com.example.demo.services;

import com.example.demo.model.student.Students;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Students> getStudent() {
        return this.studentRepository.findAll();
    }

//    public List<Students> getStudent() {
//        return List.of(
//                new Students(
//                        1L,
//                        "Sarawutt.b",
//                        "sarawutt.b@gmail.com",
//                        LocalDate.of(1986, Month.SEPTEMBER, 23),
//                        33),
//                new Students(
//                        2L,
//                        "Pogemon",
//                        "pogemon@gmail.com",
//                        LocalDate.of(2000, Month.JANUARY, 01),
//                        21
//                )
//        );
//    }
}
