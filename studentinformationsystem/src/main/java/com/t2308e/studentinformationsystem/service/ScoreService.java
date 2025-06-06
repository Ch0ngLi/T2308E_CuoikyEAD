package com.t2308e.studentinformationsystem.service;

import com.t2308e.studentinformationsystem.entity.StudentScore;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ScoreService {
    @PersistenceContext(unitName = "sisPU")
    private EntityManager em;

    public void addScore(StudentScore score) {
        em.persist(score);
    }

    public List<StudentScore> getScoresByStudentId(Integer studentId) {
        return em.createQuery(
                        "SELECT sc FROM StudentScore sc WHERE sc.student.studentId = :studentId",
                        StudentScore.class)
                .setParameter("studentId", studentId)
                .getResultList();
    }
}
