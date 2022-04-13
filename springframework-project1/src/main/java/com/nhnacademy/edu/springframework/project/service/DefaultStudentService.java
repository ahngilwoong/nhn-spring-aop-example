package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.StudentService;
import com.nhnacademy.edu.springframework.project.repository.Students;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class DefaultStudentService implements StudentService {

    @Autowired
    @Qualifier("csvStudents")
    Students studentRepository;


    @Autowired
    @Qualifier("csvScores")
    Scores scores;

    // TODO 1 : pass한 학생만 반환하도록 수정하세요. DONE
    @Override
    public List<Student> getPassedStudents() {
        for (int i = 0; i < studentRepository.findAll().size(); i++) {
            if(studentRepository.findAll().get(i).isFailChecked()){
                studentRepository.findAll().remove(i);
                i--;
            }
        }
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsOrderByScore() {
        // TODO 4 : 성적 순으로 학생 정보를 반환합니다. DONE
        Collections.sort(studentRepository.findAll(), new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int o1Score = o1.getMyScore();
                int o2Score = o2.getMyScore();
                if(o1Score>o2Score){
                    return -1;
                }else if(o1Score<o2Score){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        return studentRepository.findAll();
    }

}
