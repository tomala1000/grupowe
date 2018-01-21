package org.sda.servlets.repository;


import org.sda.servlets.domain.Course;
import org.sda.servlets.domain.Review;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @PersistenceContext
    EntityManager em;

    public Course findById(long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        Course course = new Course("QQQQQQ");
        em.persist(course);
        course.setName("Dupa");
        em.flush();
        em.detach(course);
        course.setName("ZZZZZZZ");
    }

    public void addReviewForCourse() {
        //1. Pobieramy kurs
        Course course = em.find(Course.class, 10003L);
        List<Review> reviews = course.getReviews();
        //2. Tworzymy nowe oceny (2)
        Review review1 = new Review("5", "Super");
        Review review2 = new Review("10", "Mega");
        //3. Przypisanie ocen do kursu i odwrotnie
        course.setReviews(review1);
        review1.setCourse(course);

        review2.setCourse(course);
        course.setReviews(review2);
        //4. Zapisać do bazy
        em.persist(review1);
        em.persist(review2);
    }
}
