package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;

import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class DefaultGradeQueryService implements GradeQueryService {
    @Autowired
    @Qualifier("csvStudents")
    Students students;


    @Autowired
    @Qualifier("csvScores")
    Scores scores;

    @Override
    public List<Score> getScoreByStudentName(String name) {
        // TODO 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다. DONE
        List<Score> sameNameScoreList = new ArrayList<>();
        for (int i = 0; i < students.findAll().size(); i++) {
            if(students.findAll().get(i).getName().equals(name)){
                sameNameScoreList.add(students.findAll().get(i).getScore());
            }
        }
        return sameNameScoreList;
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        // TODO 6 : 학생 번호로 점수를 반환합니다. DONE
        return scores.findAll().get(seq);
    }
}
