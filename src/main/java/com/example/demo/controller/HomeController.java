package com.example.demo.controller;

import com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final StudentService studentService;
    public HomeController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping(value="/")
    public String indexPage(){
        return "index";
    }

    @GetMapping(value="/students")
    public String studentList(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @PostMapping(value="/add-student")
    public String addStudent(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam int exam
    ){
        studentService.addStudent(name, surname, exam);
        return "redirect:/students";
    }

}
