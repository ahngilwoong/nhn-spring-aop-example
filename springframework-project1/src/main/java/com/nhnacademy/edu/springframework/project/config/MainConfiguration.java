package com.nhnacademy.edu.springframework.project.config;

import com.nhnacademy.edu.springframework.project.annotation.stdt;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@EnableAspectJAutoProxy
@Component
public class MainConfiguration {
    public CsvStudents csvStudents(@stdt CsvStudents students) {
        return new CsvStudents(students);
    }
}
