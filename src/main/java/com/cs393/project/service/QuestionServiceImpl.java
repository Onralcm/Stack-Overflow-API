package com.cs393.project.service;

import com.cs393.project.dao.AnswerPostDTO;
import com.cs393.project.dao.CommentQuestionPostDTO;
import com.cs393.project.dao.QuestionGetDTO;
import com.cs393.project.dao.QuestionPostDTO;
import com.cs393.project.mappers.MapStructMapper;
import com.cs393.project.model.Answer;
import com.cs393.project.model.Comment;
import com.cs393.project.model.Question;
import com.cs393.project.repository.AnswerRepository;
import com.cs393.project.repository.CommentRepository;
import com.cs393.project.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public QuestionGetDTO getQuestion(int questionId) {
        return mapStructMapper.questionToQuestionGetDTO(questionRepository.findById(questionId).get());
    }
    public Integer addQuestion(QuestionPostDTO questionPostDTO) {
       Question question = questionRepository.save(mapStructMapper.questionPostDTOToQuestion(questionPostDTO));
        return question.getId();
    }

    public HashMap<String, Integer> addAnswer(Integer questionId, AnswerPostDTO answerPostDTO) {
        // Increase answer count of the corresponding question here!
        Answer answer = answerRepository.save(mapStructMapper.answerPostDTOtoAnswer(answerPostDTO));
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("question_id", questionId);
        hashMap.put("answer_id", answer.getId());
        return hashMap;
    }

    public HashMap<String, Integer> addCommentToQuestion(Integer questionId, CommentQuestionPostDTO commentQuestionPostDTO) {
        Comment comment = commentRepository.save(mapStructMapper.commentQuestionPostDTOtoComment(commentQuestionPostDTO));
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("question_id", questionId);
        hashMap.put("comment_id", comment.getId());
        return hashMap;
    }

}
