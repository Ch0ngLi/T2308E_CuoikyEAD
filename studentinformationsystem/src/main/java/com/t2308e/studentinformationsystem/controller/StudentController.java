package com.t2308e.studentinformationsystem.controller;

import com.t2308e.studentinformationsystem.entity.Student;
import com.t2308e.studentinformationsystem.service.StudentService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class StudentController {
    @Inject
    private StudentService studentService;

    private Student newStudent = new Student();

    public void saveStudent() {
        studentService.addStudent(newStudent);
        newStudent = new Student(); // Reset form
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public Student getNewStudent() {
        return newStudent;
    }
}
