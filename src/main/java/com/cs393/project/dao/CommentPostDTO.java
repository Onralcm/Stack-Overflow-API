package com.cs393.project.dao;

import com.cs393.project.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentPostDTO {

    @JsonProperty("text")
    private String text;

    @JsonProperty("user")
    private User user;

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }
}
