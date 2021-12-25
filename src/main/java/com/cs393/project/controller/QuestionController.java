package com.cs393.project.controller;

import com.cs393.project.dao.QuestionGetDTO;
import com.cs393.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
