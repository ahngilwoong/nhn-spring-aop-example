package com.nhnacademy.edu.springframework.project.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.assertj.core.api.Assertions.assertThat;


class ScoresTest {
    @Autowired
    @Qualifier("csvStudents")
    Students students;


    @Autowired
    @Qualifier("csvScores")
    Scores scores;

    @Test
    void load() {
        scores.load();
        assertThat(students).isNotNull(); // 로드가 되면 리스트가 비어있지 않음으로 비어있지 않으면으로 테스트
    }

    @Test
    void findAll() {

        scores.load();
        assertThat(scores.findAll()).isNotNull();
    }
}