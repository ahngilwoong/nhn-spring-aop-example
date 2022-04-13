package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Students {
    void load();

    List<Student> findAll();

    void merge(Map<Integer,Score> scores);
}
