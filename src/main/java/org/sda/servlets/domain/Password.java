package org.sda.servlets.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "\"password\"")
public class Password {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Length(min = 8)
    private String value;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true)
    @NotNull
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
