package com.t2308e.studentinformationsystem.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "student_score_table")
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_score_id")
    private Integer studentScoreId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subject;

    @Column(name = "score1", precision = 5, scale = 2)
    private BigDecimal score1;

    @Column(name = "score2", precision = 5, scale = 2)
    private BigDecimal score2;

    // Constructors
    public StudentScore() {
    }

    public StudentScore(Student student, Subject subject, BigDecimal score1, BigDecimal score2) {
        this.student = student;
        this.subject = subject;
        this.score1 = score1;
        this.score2 = score2;
    }

    // Getters and Setters
    public Integer getStudentScoreId() {
        return studentScoreId;
    }

    public void setStudentScoreId(Integer studentScoreId) {
        this.studentScoreId = studentScoreId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public BigDecimal getScore1() {
        return score1;
    }

    public void setScore1(BigDecimal score1) {
        this.score1 = score1;
    }

    public BigDecimal getScore2() {
        return score2;
    }

    public void setScore2(BigDecimal score2) {
        this.score2 = score2;
    }

    // Business method to calculate final score
    public BigDecimal calculateFinalScore() {
        if (score1 == null || score2 == null) {
            return null;
        }
        return score1.multiply(new BigDecimal("0.3")).add(score2.multiply(new BigDecimal("0.7")));
    }

    // Business method to convert to grade
    public String calculateGrade() {
        BigDecimal finalScore = calculateFinalScore();
        if (finalScore == null) return "N/A";

        double score = finalScore.doubleValue();
        if (score >= 8.0) return "A";
        if (score >= 6.0) return "B";
        if (score >= 4.0) return "D";
        return "F";
    }
}
