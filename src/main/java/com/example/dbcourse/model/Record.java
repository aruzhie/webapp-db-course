package com.example.dbcourse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Record")
public class Record {

    @EmbeddedId RecordId recordId;

    @Column(name = "totalDeaths")
    private Integer totalDeaths;

    @Column(name = "totalPatients")
    private Integer totalPatients;

}
