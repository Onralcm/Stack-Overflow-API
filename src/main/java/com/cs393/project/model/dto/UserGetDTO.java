package com.cs393.project.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserGetDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("username")
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { this.username = username; }
}
