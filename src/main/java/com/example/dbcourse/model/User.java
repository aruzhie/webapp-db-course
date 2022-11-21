package com.example.dbcourse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "User")
public class User {

    @Id
    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "surname", length = 40)
    private String surname;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "phone", length = 20)
    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cname", referencedColumnName = "cname")
    private Country country;

}
