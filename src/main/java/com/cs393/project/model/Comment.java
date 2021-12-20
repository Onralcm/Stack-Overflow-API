package com.cs393.project.model;

import javax.persistence.*;

@Entity
@Table(name = "T_COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;

    private User user;

    private Integer voteCount;
}
