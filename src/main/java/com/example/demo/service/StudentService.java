package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Student> getAllStudents(){
        return students;
    }

    public void addStudent(String name, String surname, int exam){
        String mark = calculate(exam);
        students.add(new Student(idCounter++, name, surname, exam, mark));
    }

    private String calculate(int exam){
        if(exam >= 90) return "A";
        if(exam >= 75) return "B";
        if(exam >= 60) return "C";
        if(exam >= 50) return "D";

        return "F";
    }
}
