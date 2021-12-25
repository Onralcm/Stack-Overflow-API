package com.cs393.project.controller;

import com.cs393.project.dao.QuestionGetDTO;
import com.cs393.project.dao.QuestionPostDTO;
import com.cs393.project.model.Question;
import com.cs393.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionGetDTO>> getAll() {
        return new ResponseEntity<>(
                questionService.getQuestions(),
                HttpStatus.OK
        );
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<QuestionGetDTO> getByID(@PathVariable("id") int questionId) {
        return new ResponseEntity<>(
                questionService.getQuestion(questionId),
                HttpStatus.OK
        );
    }
    @PostMapping()
    public ResponseEntity<Integer> addQuestion(@RequestBody QuestionPostDTO questionPostDTO)
    {
               return new ResponseEntity<>(
                 questionService.addQuestion(questionPostDTO),
                 HttpStatus.CREATED
               );
    }




}
