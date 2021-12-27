package com.cs393.project.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.List;

public class QuestionPostDTO {
    @NotNull
    @JsonProperty("title")
    private String title;

    @NotNull
    @JsonProperty("description")
    private String description;

    @JsonProperty("tags")
    private List<TagGetDTO> tags;

    @JsonProperty("user")
    private UserGetDTO user;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<TagGetDTO> getTags() {
        return tags;
    }

    public UserGetDTO getUser() {
        return user;
    }

    public void setUser(UserGetDTO user) {
        this.user = user;
    }
}
