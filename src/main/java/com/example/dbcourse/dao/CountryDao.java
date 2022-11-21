package com.example.dbcourse.dao;

import com.example.dbcourse.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CountryDao {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Country> getAll() {
        String sql = "select c from Country c";
        Query query = entityManager.createQuery(sql);
        List<Country> countries = query.getResultList();
        return countries;
    }

    @Transactional
    public Country getWithName(String cname) {
        String sql = "select c from Country c where c.cname = (:name)";
        Query query = entityManager.createQuery(sql);
        query.setParameter("name", cname);
        Country country = (Country) query.getSingleResult();
        return country;
    }

    @Transactional
    public void save(Country country) {
        entityManager.merge(country);
    }

    @Transactional
    public void delete(String cname) {
        Country country = getWithName(cname);
        entityManager.remove(country);
    }

}
