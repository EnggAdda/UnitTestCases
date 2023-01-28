package com.example.unittestcases.controller;


import com.example.unittestcases.entity.Student;
import com.example.unittestcases.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/insert")
    public void insertStudent(@RequestBody Student student){

        studentService.insertStudent(student);
    }

    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable int id){

       return studentService.getStudentById(id);
    }
    @GetMapping("/findAll")
    public List<Student> findAllStudent(){

        return studentService.getAllStudents();
    }
    @PutMapping("/update/{id}")
    public Student insertStudent(@RequestBody Student student, @PathVariable int id){

       return studentService.updateStudentById(student,id);
    }
    @DeleteMapping("/delete/{id}")
    public void insertStudent(@PathVariable int id){

        studentService.deleteStudentById(id);
    }
}
