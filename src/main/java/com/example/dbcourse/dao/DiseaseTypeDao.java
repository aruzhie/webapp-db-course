package com.example.dbcourse.dao;

import com.example.dbcourse.model.DiseaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DiseaseTypeDao {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<DiseaseType> getAll() {
        String sql = "select d from DiseaseType d";
        Query query = entityManager.createQuery(sql);
        List<DiseaseType> diseaseTypes = query.getResultList();
        return diseaseTypes;
    }

    @Transactional
    public DiseaseType getWithId(Integer id) {
        String sql = "select d from DiseaseType d where d.id = (:id)";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", id);
        DiseaseType diseaseType = (DiseaseType) query.getSingleResult();
        return diseaseType;
    }

    @Transactional
    public DiseaseType getWithDescription(String description) {
        String sql = "select d from DiseaseType d where d.description = (:description)";
        Query query = entityManager.createQuery(sql);
        query.setParameter("description", description);
        DiseaseType diseaseType = (DiseaseType) query.getSingleResult();
        return diseaseType;
    }

    @Transactional
    public void save(DiseaseType diseaseType) {
        entityManager.merge(diseaseType);
    }

    @Transactional
    public void delete(Integer id) {
        DiseaseType diseaseType = getWithId(id);
        entityManager.remove(diseaseType);
    }
}
