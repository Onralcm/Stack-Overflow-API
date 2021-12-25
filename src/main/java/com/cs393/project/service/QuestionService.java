package com.cs393.project.service;

import com.cs393.project.dao.QuestionGetDTO;
import com.cs393.project.dao.QuestionPostDTO;

import java.util.List;

public interface QuestionService {
    public List<QuestionGetDTO> getQuestions();
    public QuestionGetDTO getQuestion(int questionId);
    public Integer addQuestion(QuestionPostDTO questionPostDTO);
}
