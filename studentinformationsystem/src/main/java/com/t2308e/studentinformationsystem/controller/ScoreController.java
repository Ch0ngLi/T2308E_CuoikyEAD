package com.t2308e.studentinformationsystem.controller;

import com.t2308e.studentinformationsystem.entity.Student;
import com.t2308e.studentinformationsystem.entity.StudentScore;
import com.t2308e.studentinformationsystem.entity.Subject;
import com.t2308e.studentinformationsystem.service.ScoreService;
import com.t2308e.studentinformationsystem.service.StudentService;
import com.t2308e.studentinformationsystem.service.SubjectService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.math.BigDecimal;
import java.util.List;

@Named
@RequestScoped
public class ScoreController {
    @Inject
    private ScoreService scoreService;

    @Inject
    private StudentService studentService;

    @Inject
    private SubjectService subjectService;

    private StudentScore newScore = new StudentScore();
    private Integer selectedStudentId;
    private Integer selectedSubjectId;

    public void saveScore() {
        // Set student and subject based on selected IDs
        Student student = studentService.getStudentById(selectedStudentId);
        Subject subject = subjectService.getSubjectById(selectedSubjectId);

        newScore.setStudent(student);
        newScore.setSubject(subject);

        scoreService.addScore(newScore);

        // Reset form
        newScore = new StudentScore();
        selectedStudentId = null;
        selectedSubjectId = null;
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    // Grading for ViewController
    public String calculateGrade(BigDecimal score1, BigDecimal score2) {
        if (score1 == null || score2 == null) return "N/A";

        double finalScore = score1.doubleValue() * 0.3 + score2.doubleValue() * 0.7;

        if (finalScore >= 8.0) return "A";
        if (finalScore >= 6.0) return "B";
        if (finalScore >= 4.0) return "D";
        return "F";
    }

    public StudentScore getNewScore() {
        return newScore;
    }

    public Integer getSelectedStudentId() {
        return selectedStudentId;
    }

    public void setSelectedStudentId(Integer selectedStudentId) {
        this.selectedStudentId = selectedStudentId;
    }

    public Integer getSelectedSubjectId() {
        return selectedSubjectId;
    }

    public void setSelectedSubjectId(Integer selectedSubjectId) {
        this.selectedSubjectId = selectedSubjectId;
    }
}
