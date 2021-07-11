package com.example.demo.configure;

import com.example.demo.model.student.Students;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Students pogemon = new Students(
                    "Pogemon",
                    "pogemon@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 01),
                    21
            );

            Students pikachu = new Students(
                    "Pikachu",
                    "pickachu@gmail.com",
                    LocalDate.of(2005, Month.SEPTEMBER, 23),
                    16
            );

            repository.saveAll(
                    List.of(pogemon,pikachu)
            );

        };
    }
}
