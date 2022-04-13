package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Score;

public class Student {
    private final int seq;
    private final String name;
    private Score score;

    public Student(int seq, String name) {
        this.seq = seq;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    public int getSeq() {
        return seq;
    }
    public boolean isFailChecked(){
       return score.isFail();
    }
    public void setScore(Score score) {
        this.score = score;
    }

    public int getMyScore(){
        return score.getScore();
    }

    @Override
    public String toString() {
        return "Student{" +
                "seq=" + seq +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}'+ '\n';
    }
}
