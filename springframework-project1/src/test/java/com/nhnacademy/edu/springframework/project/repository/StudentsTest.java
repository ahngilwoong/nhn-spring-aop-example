package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {
    @Autowired
    @Qualifier("csvStudents")
    Students students;


    @Autowired
    @Qualifier("csvScores")
    Scores scores;


    @BeforeEach
    void setUp(){
        students.load();
    }

    @Test
    void load() {
        assertThat(students.findAll()).isNotEmpty(); // 로드가 되었으면 리스트가 안비어있을것이다.
    }

    @Test
    void findAll() {
        assertThat(students.findAll().size()).isEqualTo(4); // 학생 수 4
    }

    @Test
    void merge() {
        scores.load();
        students.merge(scores.findAll());
        assertThat(students.findAll().get(0).getMyScore()).isEqualTo(30); // 합친 뒤 스튜던트의 속성으로 스코어를 확인하여 첫번째 학생의 점수 30점
    }
}