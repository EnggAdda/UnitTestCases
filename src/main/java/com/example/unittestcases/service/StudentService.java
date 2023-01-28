package com.example.unittestcases.service;




import com.example.unittestcases.entity.Student;

import java.util.List;


public interface StudentService {

    Student insertStudent(Student student);

    Student getStudentById(int id );

    List<Student> getAllStudents();

   Student updateStudentById(Student student , int id);



   String  deleteStudentById(int id);
}
