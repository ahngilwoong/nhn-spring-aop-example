package com.nhnacademy.edu.springframework.project.config;


import com.nhnacademy.edu.springframework.project.annotation.stdt;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Students;
import com.nhnacademy.edu.springframework.project.service.Student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    @stdt
    public Students csvStudents() {
        return new CsvStudents();
    }
}
