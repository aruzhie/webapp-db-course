package com.example.dbcourse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "PublicServant")
public class PublicServant {

    @Id
    @Column(name = "email", length = 60)
    private String email;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

    @Column(name = "department", length = 50)
    private String department;

}
