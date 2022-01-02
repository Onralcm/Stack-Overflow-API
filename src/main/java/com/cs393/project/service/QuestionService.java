package com.cs393.project.service;

import com.cs393.project.model.dto.AnswerPostDTO;
import com.cs393.project.model.dto.CommentPostDTO;
import com.cs393.project.model.dto.QuestionGetDTO;
import com.cs393.project.model.dto.QuestionPostDTO;

import java.util.HashMap;
import java.util.List;

public interface QuestionService {
    List<QuestionGetDTO> getQuestions();
    List<QuestionGetDTO> getQuestionsFromTags(List<String> tags);
    QuestionGetDTO getQuestion(int questionId);
    Integer addQuestion(QuestionPostDTO questionPostDTO);
    HashMap<String, Integer> addAnswer(Integer questionId, AnswerPostDTO answerPostDTO);
    HashMap<String, Integer> addCommentToQuestion(Integer questionId, CommentPostDTO commentPostDTO);
    HashMap<String, Integer> addCommentToAnswer(Integer answerId, CommentPostDTO commentPostDTO);
    Integer voteQuestion(Integer questionId);
    Integer voteAnswer(Integer answerId);
    Integer voteComment(Integer commentId);
    Integer deleteComment(Integer commentId);
    Integer updateAnswer(Integer answerId, String answerText);
    Integer updateComment(Integer commentId, String commentText);
}
