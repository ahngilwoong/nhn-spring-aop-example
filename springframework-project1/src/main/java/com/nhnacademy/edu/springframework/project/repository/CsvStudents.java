package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/** TODO 3 : load 를 완료전에 기타 메소드 실행시 IllegalStateException 이 발생해야 한다.
 **/

/**
 * TODO 7 : singleton 클래스를 만드세요. //DONE
 */
@ControllerAdvice
public class CsvStudents implements Students {

    private CsvStudents csvStudents;
    List<Student> studentsList = new ArrayList<>();


 //   public static Students getInstance() {return csvStudents;}

    public CsvStudents(){
    }
    @Autowired
    public CsvStudents(CsvStudents csvStudent) {
        this.csvStudents = csvStudent;
    }

    // TODO 6 : student.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요. // DONE
    @Override
    @ExceptionHandler(IllegalStateException.class)
    public void load() {
        BufferedReader br = null;
        String line;
        URL resource = getClass().getClassLoader().getResource("data/student.csv");
        String path = resource.getFile();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(","); // 쉼표로 구분
                for (int i = 0; i < temp.length; i += 2) {
                    studentsList.add(new Student(Integer.parseInt(temp[i]), temp[i + 1]));
                }
            }
        } catch (Exception e) {
        }
    }
    @Override
    public List<Student> findAll() {
        return studentsList;
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요. DONE
     * @param scores
     */
    @Override
    public void merge(Map<Integer,Score> scores) {
        // this.studentsList.get(scores.)
        for (int i = 0; i < studentsList.size(); i++) {
            studentsList.get(i).setScore(scores.get(studentsList.get(i).getSeq()));
        }
    }
}
