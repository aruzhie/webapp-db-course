package com.example.dbcourse.dao;

import com.example.dbcourse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<User> getAll() {
        String sql = "select u from User u";
        Query query = entityManager.createQuery(sql);
        List<User> users = query.getResultList();
        return users;
    }

    @Transactional
    public User getWithEmail(String email) {
        System.out.println(email);
        String sql = "select u from User u where u.email = (:email)";
        Query query = entityManager.createQuery(sql);
        query.setParameter("email", email);
        User user = (User) query.getSingleResult();
        return user;
    }

    @Transactional
    public void save(User user) {
        entityManager.merge(user);
    }

    @Transactional
    public void delete(String email) {
        User user = getWithEmail(email);
        entityManager.remove(user);
    }
}
