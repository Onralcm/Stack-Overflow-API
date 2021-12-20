package com.cs393.project.service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_ANSWER")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;

    private Integer voteCount;

    private Question question;

    private User owner;

    private List<Comment> comments;
}
