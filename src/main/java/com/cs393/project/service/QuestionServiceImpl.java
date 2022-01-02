package com.cs393.project.service;

import com.cs393.project.model.dto.AnswerPostDTO;
import com.cs393.project.model.dto.CommentPostDTO;
import com.cs393.project.model.dto.QuestionGetDTO;
import com.cs393.project.model.dto.QuestionPostDTO;
import com.cs393.project.mappers.MapStructMapper;
import com.cs393.project.model.*;
import com.cs393.project.repository.AnswerRepository;
import com.cs393.project.repository.CommentRepository;
import com.cs393.project.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private MapStructMapper mapStructMapper;

    @Autowired
    public QuestionServiceImpl(MapStructMapper mapStructMapper) {
        this.mapStructMapper = mapStructMapper;
    }

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    CommentRepository commentRepository;

    public List<QuestionGetDTO> getQuestions() {
        return mapStructMapper.questionsToQuestionsGetDTO(questionRepository.findAll());
    }
    public List<QuestionGetDTO> getQuestionsFromTags(List<String> tags){
        return mapStructMapper.questionsToQuestionsGetDTO(questionRepository.findAllFromTags(tags));
    }
    public QuestionGetDTO getQuestion(int questionId) {
        return mapStructMapper.questionToQuestionGetDTO(questionRepository.findById(questionId).get());
    }
    public Integer addQuestion(QuestionPostDTO questionPostDTO) {
        Question question = questionRepository.save(mapStructMapper.questionPostDTOToQuestion(questionPostDTO));
        return question.getId();
    }
    public HashMap<String, Integer> addAnswer(Integer questionId, AnswerPostDTO answerPostDTO) {
        Answer answer = mapStructMapper.answerPostDTOtoAnswer(answerPostDTO);
        Question question = questionRepository.findById(questionId).get();
        answer.setQuestion(question);
        question.setAnswerCount(question.getAnswerCount()+1);
        questionRepository.save(question);
        answer = answerRepository.save(answer);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("question_id", questionId);
        hashMap.put("answer_id", answer.getId());
        return hashMap;
    }

    public HashMap<String, Integer> addCommentToQuestion(Integer questionId, CommentPostDTO commentPostDTO) {
        Comment comment = mapStructMapper.commentQuestionPostDTOtoComment(commentPostDTO);
        Question question = questionRepository.findById(questionId).get();
        comment.setQuestion(question);
        commentRepository.save(comment);
        comment = commentRepository.save(comment);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("question_id", questionId);
        hashMap.put("comment_id", comment.getId());
        return hashMap;
    }
    public HashMap<String, Integer> addCommentToAnswer(Integer answerId, CommentPostDTO commentPostDTO) {
        Comment comment = mapStructMapper.commentQuestionPostDTOtoComment(commentPostDTO);
        Answer answer = answerRepository.findById(answerId).get();
        comment.setAnswer(answer);
        commentRepository.save(comment);
        comment = commentRepository.save(comment);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("answer_id", answerId);
        hashMap.put("comment_id", comment.getId());
        return hashMap;
    }
    public Integer voteQuestion(Integer questionId) {
        Question question = questionRepository.findById(questionId).get();
        question.setVoteCount(question.getVoteCount()+1);
        questionRepository.save(question);
        return question.getVoteCount();
    }
    public Integer voteAnswer(Integer answerId) {
        Answer answer = answerRepository.findById(answerId).get();
        answer.setVoteCount(answer.getVoteCount()+1);
        answerRepository.save(answer);
        return answer.getVoteCount();
    }
    public Integer voteComment(Integer commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        comment.setVoteCount(comment.getVoteCount()+1);
        commentRepository.save(comment);
        return comment.getVoteCount();
    }
    @Transactional
    public Integer deleteComment(Integer commentId) {
        Comment comment = commentRepository.getById(commentId);
        Question question = comment.getQuestion();
        Answer answer = comment.getAnswer();
        User user = comment.getUser();
        if(question != null)
            question.getComments().remove(comment);
        if(question != null)
            answer.getComments().remove(comment);
        user.getComments().remove(comment);
        commentRepository.delete(comment);
        return 1;
    }
    public Integer updateAnswer(Integer answerId, String answerText) {
        Answer answer = answerRepository.findById(answerId).get();
        answer.setText(answerText);
        answerRepository.save(answer);
        return 1;
    }
    public Integer updateComment(Integer commentId, String commentText) {
        Comment comment = commentRepository.findById(commentId).get();
        comment.setText(commentText);
        commentRepository.save(comment);
        return 1;
    }
}
