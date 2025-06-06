package com.t2308e.studentinformationsystem.service;

import com.t2308e.studentinformationsystem.entity.Subject;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SubjectService {
    @PersistenceContext(unitName = "sisPU")
    private EntityManager em;

    public List<Subject> getAllSubjects() {
        return em.createQuery("SELECT s FROM Subject s", Subject.class)
                .getResultList();
    }

    public Subject getSubjectById(Integer id) {
        return em.find(Subject.class, id);
    }
}
