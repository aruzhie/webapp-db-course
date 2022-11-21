package com.example.dbcourse.dao;

import com.example.dbcourse.model.PublicServant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PublicServantDao {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<PublicServant> getAll() {
        String sql = "select p from PublicServant p";
        Query query = entityManager.createQuery(sql);
        List<PublicServant> publicServants = query.getResultList();
        return publicServants;
    }

    @Transactional
    public PublicServant getWithEmail(String email) {
        String sql = "select p from PublicServant p where p.email = (:email)";
        Query query = entityManager.createQuery(sql);
        query.setParameter("email", email);
        PublicServant publicServant = (PublicServant) query.getSingleResult();
        return publicServant;
    }

    @Transactional
    public void save(PublicServant publicServant) {
        entityManager.merge(publicServant);
    }

    @Transactional
    public void delete(String email) {
        PublicServant publicServant = getWithEmail(email);
        entityManager.remove(publicServant);
    }
}
