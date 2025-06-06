package com.t2308e.studentinformationsystem.service;

import com.t2308e.studentinformationsystem.entity.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentService {
    @PersistenceContext(unitName = "sisPU")
    private EntityManager em;

    public void addStudent(Student student) {
        em.persist(student);
    }

    public List<Student> getAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
    }

    public Student getStudentById(Integer id) {
        return em.find(Student.class, id);
    }
}
