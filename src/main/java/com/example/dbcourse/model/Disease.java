package com.example.dbcourse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Disease")
public class Disease {

    @Id
    @Column(name = "diseaseCode", length = 50)
    private String code;

    @Column(name = "pathogen", length = 20)
    private String pathogen;

    @Column(name = "description", length = 140)
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private DiseaseType type;

}
