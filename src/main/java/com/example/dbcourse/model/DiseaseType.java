package com.example.dbcourse.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "DiseaseType")
public class DiseaseType {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "description", length = 140)
    private String description;

}
