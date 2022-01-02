package com.cs393.project.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class QuestionGetDTO {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tags")
    private List<TagGetDTO> tags;

    @JsonProperty("askedDate")
    private Date askedDate;

    @JsonProperty("user")
    private UserGetDTO user;

    @JsonProperty("answerCount")
    private Integer answerCount;

    @JsonProperty("voteCount")
    private Integer voteCount;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        if(description.length() > 100)
            this.description = description.substring(0,100);
        else
            this.description = description;
    }

    public void setTags(List<TagGetDTO> tags) {
        this.tags = tags;
    }

    public void setAskedDate(Date askedDate) {
        this.askedDate = askedDate;
    }

    public UserGetDTO getUser() { return user; }

    public void setUser(UserGetDTO user) {
        this.user = user;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}
