package com.example.dbcourse.dao;

import com.example.dbcourse.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RecordDao {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Record> getAll() {
        String sql = "select r from Record r";
        Query query = entityManager.createQuery(sql);
        List<Record> records = query.getResultList();
        return records;
    }

    @Transactional
    public Record getWith(String email, String cname, String diseaseCode) {
        String sql = "select r from Record r where r.recordId.user.email = (:email) and r.recordId.country.cname = (:cname) and r.recordId.disease.code = (:diseaseCode)";
        Query query = entityManager.createQuery(sql);
        query.setParameter("email", email);
        query.setParameter("cname", cname);
        query.setParameter("diseaseCode", diseaseCode);
        Record record = (Record) query.getSingleResult();
        return record;
    }

    @Transactional
    public void save(Record record) {
        entityManager.merge(record);
    }

    @Transactional
    public void delete(String email, String cname, String diseaseCode) {
        Record record = getWith(email, cname, diseaseCode);
        entityManager.remove(record);
    }
}
