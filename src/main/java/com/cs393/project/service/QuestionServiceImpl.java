package com.cs393.project.service;

import com.cs393.project.dao.QuestionGetDTO;
import com.cs393.project.dao.QuestionPostDTO;
import com.cs393.project.mappers.MapStructMapper;
import com.cs393.project.model.Question;
import com.cs393.project.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public List<QuestionGetDTO> getQuestions() {
        return mapStructMapper.questionsToQuestionsGetDTO(questionRepository.findAll());
    }
    public QuestionGetDTO getQuestion(int questionId) {
        return mapStructMapper.questionToQuestionGetDTO(questionRepository.findById(questionId).get());
    }
    public Integer addQuestion(QuestionPostDTO questionPostDTO) {
       Question question = questionRepository.save(mapStructMapper.QuestionPostDTOToQuestion(questionPostDTO));
        return question.getId();
    }

}
