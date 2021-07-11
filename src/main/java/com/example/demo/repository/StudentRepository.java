package com.example.demo.repository;

import com.example.demo.model.student.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Long> {

}
