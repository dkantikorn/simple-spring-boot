package com.example.demo.repository;

import com.example.demo.entity.student.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {

    @Query("SELECT s FROM Students s WHERE s.email = ?1")
    Optional<Students> findStudensByEmail(String email);
}
