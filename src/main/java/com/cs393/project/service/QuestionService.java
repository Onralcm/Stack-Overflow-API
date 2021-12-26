package com.cs393.project.service;

import com.cs393.project.dao.AnswerPostDTO;
import com.cs393.project.dao.CommentQuestionPostDTO;
import com.cs393.project.dao.QuestionGetDTO;
import com.cs393.project.dao.QuestionPostDTO;

import java.util.HashMap;
import java.util.List;

public interface QuestionService {
    public List<QuestionGetDTO> getQuestions();
    public QuestionGetDTO getQuestion(int questionId);
    public Integer addQuestion(QuestionPostDTO questionPostDTO);
    public HashMap<String, Integer> addAnswer(Integer questionId, AnswerPostDTO answerPostDTO);
    public HashMap<String, Integer> addCommentToQuestion(Integer questionId, CommentQuestionPostDTO commentQuestionPostDTO);
}
