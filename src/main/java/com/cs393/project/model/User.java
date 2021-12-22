package com.cs393.project.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private List<Answer> answers;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<Question> questions;
}
