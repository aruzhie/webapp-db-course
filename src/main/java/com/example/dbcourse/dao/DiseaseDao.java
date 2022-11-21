package com.example.dbcourse.dao;

import com.example.dbcourse.model.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DiseaseDao {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Disease> getAll() {
        String sql = "select d from Disease d";
        Query query = entityManager.createQuery(sql);
        List<Disease> diseases = query.getResultList();
        return diseases;
    }

    @Transactional
    public Disease getWithCode(String code) {
        String sql = "select d from Disease d where d.code = (:code)";
        Query query = entityManager.createQuery(sql);
        query.setParameter("code", code);
        Disease disease = (Disease) query.getSingleResult();
        return disease;
    }

    @Transactional
    public void save(Disease disease) {
        entityManager.merge(disease);
    }

    @Transactional
    public void delete(String code) {
        Disease disease = getWithCode(code);
        entityManager.remove(disease);
    }
}
