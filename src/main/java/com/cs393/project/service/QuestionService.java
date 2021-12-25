package com.cs393.project.service;

import com.cs393.project.dao.QuestionGetDTO;

import java.util.List;

public interface QuestionService {
    public List<QuestionGetDTO> getQuestions();
}
