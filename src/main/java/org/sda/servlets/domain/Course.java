package org.sda.servlets.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@NamedQueries(value = {
        @NamedQuery(name = "get_all_courses", query = "select c from Course c"),
        @NamedQuery(name = "get_courses_named_testowo4",
                query = "select c from Course c where name='Testowo4'")
})
public class Course {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    List<User> users = new ArrayList<>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Review review) {
        this.reviews.add(review);
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
