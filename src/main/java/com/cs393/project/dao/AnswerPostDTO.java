package com.cs393.project.dao;

import com.cs393.project.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerPostDTO {

    @JsonProperty("text")
    private String text;

    @JsonProperty("user")
    private User user;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
