package com.example.demo.services;

import com.example.demo.entity.student.Students;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Function list all of the student
     *
     * @return list of student
     */
    public List<Students> getStudent() {
        return this.studentRepository.findAll();
    }


    /**
     * Function making for Add new for student
     *
     * @param student
     */
    public void registerNewStudent(Students student) {

        Optional<Students> studentOptional = studentRepository.findStudensByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("The Email is already taken");
        }

        studentRepository.save(student);
//        System.out.println(student);
    }

    /**
     * Delete the student by student id with parameter
     *
     * @param studentId as long of the student id where you want to delete
     */
    public void deleteStudentById(Long studentId) {
        Boolean isExists = studentRepository.existsById(studentId);
        if (!isExists) {
            throw new IllegalStateException("Student with id = " + studentId + " dose not exists!!!");
        }
        studentRepository.deleteById(studentId);
    }

    /**
     * Function making for update the student information
     *
     * @param studentId as student id where you want to update the infomation
     * @param name      as student name
     * @param email     as student of email
     */
//    @Transactional(rollbackFor = {Exception.class})
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Students student = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id = " + studentId + " dose not exists!!!!"));

        //Check and set the student name
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Students> studentOptional = studentRepository.findStudensByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("student email = " + email + " already taken");
            }
            student.setEmail(email);
        }
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
