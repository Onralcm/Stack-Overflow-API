package com.cs393.project.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagGetDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("tag")
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
