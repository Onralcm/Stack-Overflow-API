package com.cs393.project.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_QUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private Date askedDate;

    // dont know this
    private List<Tag> tags;

    @ManyToOne
    private User owner;

    @OneToMany
    private List<Answer> answers;

    private Integer answerCount;

    private Integer voteCount;

    // dont know this
    private List<Comment> comments;

}
