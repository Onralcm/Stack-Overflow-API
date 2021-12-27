package com.cs393.project.controller;

import com.cs393.project.dao.AnswerPostDTO;
import com.cs393.project.dao.CommentPostDTO;
import com.cs393.project.dao.QuestionGetDTO;
import com.cs393.project.dao.QuestionPostDTO;
import com.cs393.project.model.Answer;
import com.cs393.project.model.Comment;
import com.cs393.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    @GetMapping("/fromTags")
    public ResponseEntity<List<QuestionGetDTO>> getAllFromTags(@RequestBody List<String> tags){
        return new ResponseEntity<>(
                questionService.getQuestionsFromTags(tags),
                HttpStatus.OK
        );
    }
    @GetMapping( "/{id}")
    public ResponseEntity<QuestionGetDTO> getByID(@PathVariable("id") int questionId) {
        return new ResponseEntity<>(
                questionService.getQuestion(questionId),
                HttpStatus.OK
        );
    }
    @PostMapping
    public ResponseEntity<Integer> addQuestion(@RequestBody QuestionPostDTO questionPostDTO)
    {
               return new ResponseEntity<>(
                 questionService.addQuestion(questionPostDTO),
                 HttpStatus.CREATED
               );
    }

    @PostMapping("/{question-id}/answers")
    public ResponseEntity<HashMap<String, Integer>> addAnswerToQuestion(@PathVariable("question-id") int questionId, @RequestBody AnswerPostDTO answerPostDTO) {
        return new ResponseEntity<>(
                questionService.addAnswer(questionId, answerPostDTO),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/{question-id}/comments")
    public ResponseEntity<HashMap<String, Integer>> addCommentToQuestion(@PathVariable("question-id") int questionId, @RequestBody CommentPostDTO commentPostDTO) {
        return new ResponseEntity<>(
                questionService.addCommentToQuestion(questionId, commentPostDTO),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/{question-id}/answers/{answer-id}/comments")
    public ResponseEntity<HashMap<String, Integer>> addCommentToAnswer(@PathVariable("answer-id") int answerId, @RequestBody CommentPostDTO commentPostDTO) {
        return new ResponseEntity<>(
                questionService.addCommentToAnswer(answerId, commentPostDTO),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{question-id}")
    public ResponseEntity<Integer> votingQuestion(@PathVariable("question-id") Integer questionId) {
        return new ResponseEntity<>(
                questionService.voteQuestion(questionId),
                HttpStatus.OK
        );
    }

    @PutMapping("/answers/{answer-id}")
    public ResponseEntity<Integer> votingAnswer(@PathVariable("answer-id") Integer answerId) {
        return new ResponseEntity<>(
                questionService.voteAnswer(answerId),
                HttpStatus.OK
        );
    }

    @PutMapping("/comments/{comment-id}")
    public ResponseEntity<Integer> votingComment(@PathVariable("comment-id") Integer commentId) {
        return new ResponseEntity<>(
                questionService.voteComment(commentId),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/comments/{comment-id}")
    public ResponseEntity<Integer> deleteComment(@PathVariable("comment-id") Integer commentId) {
        return new ResponseEntity<>(
                questionService.deleteComment(commentId),
                HttpStatus.OK
        );
    }

    @PutMapping("/answers/update/{answer-id}")
    public ResponseEntity<Integer> updateAnswer(@PathVariable("answer-id") Integer answerId, @RequestBody Answer answerText) {
        return new ResponseEntity<>(
                questionService.updateAnswer(answerId, answerText),
                HttpStatus.OK
        );
    }

    @PutMapping("/comments/update/{comment-id}")
    public ResponseEntity<Integer> updateComment(@PathVariable("comment-id") Integer commentId, @RequestBody Comment commentText) {
        return new ResponseEntity<>(
                questionService.updateComment(commentId, commentText),
                HttpStatus.OK
        );
    }
}
