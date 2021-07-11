package com.example.demo.repository;

import com.example.demo.entity.student.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {

    @Query("SELECT s FROM Students s WHERE s.email = ?1")
    Optional<Students> findStudensByEmail(String email);

//    @Modifying //ถ้ามีการแก้ไขเปลี่ยนแปลงข้อมูลต้องมี @Modifying เสมอ เช่นการ update หรือ delete
//    @Query("UPDATE Students student SET student.deleted = ?2 WHERE nws = ?1")
//    public void updateForStudent(Students student, Boolean deleted);
}
