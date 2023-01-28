package com.example.unittestcases.service.impl;


import com.example.unittestcases.entity.Student;
import com.example.unittestcases.repo.StudentRepo;
import com.example.unittestcases.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Student insertStudent(Student student) {

        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        Student s = studentRepo.findById(id).get();
     return s;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student updateStudentById(Student student, int id) {
        Student studentFromDb  = studentRepo.findById(id).get();

        studentFromDb.setName(student.getName());
        studentFromDb.setAge(student.getAge());
        studentFromDb.setAddress(student.getAddress());
        studentFromDb.setFatherName(student.getFatherName());
        return studentRepo.save(studentFromDb);
    }

    @Override
    public String deleteStudentById(int id) {
        studentRepo.deleteById(id);
        return "student with id:-"+id+"got deleted";

    }
}
