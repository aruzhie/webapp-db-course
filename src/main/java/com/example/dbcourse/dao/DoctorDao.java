package com.example.dbcourse.dao;

import com.example.dbcourse.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DoctorDao {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Doctor> getAll() {
        String sql = "select d from Doctor d";
        Query query = entityManager.createQuery(sql);
        List<Doctor> doctors = query.getResultList();
        return doctors;
    }

    @Transactional
    public Doctor getWithEmail(String email) {
        String sql = "select d from Doctor d where d.email = (:email)";
        Query query = entityManager.createQuery(sql);
        query.setParameter("email", email);
        Doctor doctor = (Doctor) query.getSingleResult();
        return doctor;
    }

    @Transactional
    public void save(Doctor doctor) {
        entityManager.merge(doctor);
    }

    @Transactional
    public void delete(String email) {
        Doctor doctor = getWithEmail(email);
        entityManager.remove(doctor);
    }
}
