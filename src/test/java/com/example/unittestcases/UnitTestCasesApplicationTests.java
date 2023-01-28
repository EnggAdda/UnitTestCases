package com.example.unittestcases;



import com.example.unittestcases.entity.Student;
import com.example.unittestcases.repo.StudentRepo;
import com.example.unittestcases.service.StudentService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class UnitTestCasesApplicationTests {

    @Test
    void contextLoads() {
    }

    @MockBean
    private StudentRepo studentRepo;

    @Autowired
    private StudentService studentService;

    @Test
    public void insertStudentTest() {

       Student student = new Student(101,"Ram","Rajan","Delhi",24);
       when(studentRepo.save(student)).thenReturn(student);
       assertEquals("Ram",studentService.insertStudent(student).getName());
    }

    @Test
    public void getStudentByIdTest() {

        Student student = new Student(101,"Ram","Rajan","Delhi",24);
        when(studentRepo.findById(101)).thenReturn(Optional.of(student));
        assertEquals(Integer.valueOf(101) ,studentService.getStudentById(student.getId()).getId());
    }

    @Test
    public void getAllStudentTest() {

       List<Student> studentList = Stream.of(
               new Student(101,"Ram","Rajan","Delhi",24)
               ,new Student(102,"Rahul","Rajan","Delhi",24)).collect(Collectors.toList());

       when(studentRepo.findAll()).thenReturn(studentList);
        assertEquals(2,studentService.getAllStudents().size());
    }

    @Test
    public void updateStudentByIdTest() {

        Student student = new Student(101,"Ram","Rajan","Delhi",24);
        when(studentRepo.findById(101)).thenReturn(Optional.of(student));
        student.setName("Naman");
        when(studentRepo.save(student)).thenReturn(student);
        assertEquals("Naman",studentService.updateStudentById(student,101).getName());
    }

    @Test
    public void deleteStudentByIdTest() {

        Student student = new Student(101,"Ram","Rajan","Delhi",24);

        assertEquals("student with id:-"+student.getId()+"got deleted",studentService.deleteStudentById(101));
    }






}
