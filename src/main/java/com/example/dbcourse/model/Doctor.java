package com.example.dbcourse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Doctor")
public class Doctor {

    @Id
    @Column(name = "email", length = 60)
    private String email;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

    @Column(name = "degree", length = 20)
    private String degree;

}
