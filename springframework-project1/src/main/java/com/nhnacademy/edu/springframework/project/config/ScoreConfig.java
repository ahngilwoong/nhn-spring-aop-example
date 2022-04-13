package com.nhnacademy.edu.springframework.project.config;

import com.nhnacademy.edu.springframework.project.annotation.stdt;
import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScoreConfig {
    @Bean
    public CsvScores csvScores() {
        return new CsvScores();
    }
}
