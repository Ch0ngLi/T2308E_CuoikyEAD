package com.t2308e.studentinformationsystem.controller;

import com.t2308e.studentinformationsystem.entity.Student;
import com.t2308e.studentinformationsystem.service.StudentService;
import com.t2308e.studentinformationsystem.service.SubjectService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ViewController {
    @Inject
    private StudentService studentService;

    @Inject
    private SubjectService subjectService;

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Calculate final score
    public double calculateFinalScore(Double score1, Double score2) {
        if (score1 == null || score2 == null) return 0.0;
        return score1 * 0.3 + score2 * 0.7;
    }

    // Convert to grade
    public String convertToGrade(Double score1, Double score2) {
        double finalScore = calculateFinalScore(score1, score2);

        if (finalScore >= 8.0) return "A";
        if (finalScore >= 6.0) return "B";
        if (finalScore >= 4.0) return "D";
        return "F";
    }
}
