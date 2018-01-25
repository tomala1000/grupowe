package org.sda.servlets.repository;


import org.sda.servlets.domain.Password;
import org.sda.servlets.domain.User;
import org.sda.servlets.util.PasswordUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void deleteById(long id) {
        User userToDelete = findById(id);
        em.remove(userToDelete);
    }

    @Transactional
    public List<User> findAll(){
        return (List<User>) em.createQuery("select u from User u").getResultList();
    }


    @Transactional(readOnly = true)
    public List<User> findBy(String name){
        Query query = em.createQuery("select u from User u where u.firstName like :name");
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Transactional
    public User save(User user, String passw) {
        if (user.getId() == null) {
            em.persist(user);
            Password password = new Password();
            password.setUser(user);
            password.setValue(PasswordUtil.hashPassword(passw));
            em.persist(password);
        } //nowy wpis
        else {
            throw new UnsupportedOperationException();
        }
        return user;
    }

    @Transactional
    public User update(User user){
        em.merge(user);
        return user;
    }

}

