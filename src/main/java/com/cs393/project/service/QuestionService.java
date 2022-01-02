package com.cs393.project.service;

import com.cs393.project.dao.AnswerPostDTO;
import com.cs393.project.dao.CommentPostDTO;
import com.cs393.project.dao.QuestionGetDTO;
import com.cs393.project.dao.QuestionPostDTO;
import com.cs393.project.model.Answer;
import com.cs393.project.model.Comment;

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
