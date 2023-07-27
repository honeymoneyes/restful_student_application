package com.alex.application.config;

import com.alex.application.entity.Student;
import com.alex.application.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        Student tatiana = Student.builder()
                .name("Tatiana")
                .email("tati@gmail.com")
                .dob(LocalDate.of(1972, 2, 12))
                .build();

        Student nikolay = Student.builder()
                .name("Nikolay")
                .email("nikolay@gmail.com")
                .dob(LocalDate.of(1976, 7, 10))
                .build();
        Student andrew = Student.builder()
                .name("Andrew")
                .email("andrew@gmail.com")
                .dob(LocalDate.of(2004, 4, 4))
                .build();

        Student alex = Student.builder()
                .name("Alex")
                .email("alex@gmail.com")
                .dob(LocalDate.of(1998, 2, 19))
                .build();
        return args -> studentRepository.saveAll(List.of(
                tatiana,
                nikolay,
                andrew,
                alex));
    }
}
