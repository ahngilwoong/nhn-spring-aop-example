package com.nhnacademy.edu.springframework.project.repository;

import java.util.List;
import java.util.Map;

public interface Scores {
    void load();

    Map<Integer,Score> findAll();

    int getMapSize();
}
