package com.cs393.project.model;

import javax.persistence.*;

@Entity
@Table(name = "T_TAG")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
