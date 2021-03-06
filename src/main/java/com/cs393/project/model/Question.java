package com.cs393.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_QUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 5000)
    private String title;

    @Column(length = 5000)
    private String description;

    private Date askedDate = new Date();

    @ManyToMany
    @JoinTable(name = "REL_QUESTION_TAG",
    joinColumns = @JoinColumn(name = "QUESTION_ID", referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name = "TAG_ID", referencedColumnName = "ID"))
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    private Integer answerCount = 0;

    private Integer voteCount = 0;

    @OneToMany(mappedBy = "question")
    private List<Comment> comments = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAskedDate() {
        return askedDate;
    }

    public void setAskedDate(Date askedDate) {
        this.askedDate = askedDate;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
