package com.cs393.project.model;

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

    @ManyToOne
    private Question question;

    @ManyToOne
    private User owner;

    // dont know this
    private List<Comment> comments;
}
