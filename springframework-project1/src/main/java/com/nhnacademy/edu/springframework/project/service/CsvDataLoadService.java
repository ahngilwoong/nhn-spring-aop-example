package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CsvDataLoadService implements DataLoadService {
    @Autowired
    @Qualifier("csvStudents")
    Students students;


    @Autowired
    @Qualifier("csvScores")
    Scores scores;

    @Override
    public void loadAndMerge() {
        scores.load();
        students.load();
        students.merge(scores.findAll());
    }
}
