package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    List<Student> getPassedStudents();
    List<Student> getStudentsOrderByScore();
}
