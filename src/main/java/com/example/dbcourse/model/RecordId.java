package com.example.dbcourse.model;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class RecordId implements Serializable {

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cname", referencedColumnName = "cname")
    private Country country;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "diseaseCode", referencedColumnName = "diseaseCode")
    private Disease disease;

    public User getUser() {
        return user;
    }

    public Country getCountry() {
        return country;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}
