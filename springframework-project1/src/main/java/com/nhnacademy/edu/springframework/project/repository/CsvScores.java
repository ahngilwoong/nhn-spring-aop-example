package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** TODO 2 : load 를 완료전에 기타 메소드 실행시 IllegalStateException 이 발생해야 한다.
 **/
@ControllerAdvice

public class CsvScores implements Scores {
    private static Map<Integer,Score> scoreList = new HashMap<>();
    private  CsvScores csvScores;



    public CsvScores(){}

    public CsvScores(CsvScores csvScores) {
        this.csvScores = csvScores;
    }
//    public static Scores getInstance() {
//       return Objects.equals(scoreList,null) ? null : csvScores;
//    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요. DONE
    @Override
    @ExceptionHandler(IllegalStateException.class)
    public void load() {
        BufferedReader br = null;
        String line;
        URL resource = getClass().getClassLoader().getResource("data/score.csv");
        String path = resource.getFile();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            while((line = br.readLine()) != null) {
                String[] temp = line.split(","); // 쉼표로 구분
                for(int i=0; i<temp.length; i+=2) {
                    scoreList.put(Integer.parseInt(temp[i]),new Score(Integer.parseInt(temp[i]),Integer.parseInt(temp[i+1])));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getMapSize(){
        return scoreList.size();
    }




    @Override
    public Map<Integer,Score> findAll() {
        return scoreList;
    }
}
