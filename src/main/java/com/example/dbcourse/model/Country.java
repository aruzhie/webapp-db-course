package com.example.dbcourse.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Country")
public class Country {

    @Id
    @Column(name = "cname", length = 50)
    private String cname;

    @Column(name = "population")
    private Long population;

}
