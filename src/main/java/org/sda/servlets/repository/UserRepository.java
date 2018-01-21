package org.sda.servlets.repository;


import org.sda.servlets.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public User findById(long id) {
        return em.find(User.class, id);
    }

    public void deleteById(long id) {
        User userToDelete = findById(id);
        em.remove(userToDelete);
    }

    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
        } //nowy wpis
        else {
            em.merge(user);
        } //aktualizacja poprzedniego
        return user;
    }

}

