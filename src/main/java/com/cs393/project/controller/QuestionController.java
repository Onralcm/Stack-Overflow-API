package com.cs393.project.controller;

import com.cs393.project.model.dto.AnswerPostDTO;
import com.cs393.project.model.dto.CommentPostDTO;
import com.cs393.project.model.dto.QuestionGetDTO;
import com.cs393.project.model.dto.QuestionPostDTO;
import com.cs393.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping
    @Operation(summary = "get all questions", description = "You can read all information about questions.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<List<QuestionGetDTO>> getAll() {
        return new ResponseEntity<>(
                questionService.getQuestions(),
                HttpStatus.OK
        );
    }

    @GetMapping("/fromTags/{tags}")
    @Operation(summary = "get all questions related to one of the given tags", description = "You can read all information about questions that have one of the given tags.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<List<QuestionGetDTO>> getAllFromTags(@Parameter(description="The entered tags cannot be empty.", required=true)
                                                               @PathVariable List<String> tags){
        return new ResponseEntity<>(
                questionService.getQuestionsFromTags(tags),
                HttpStatus.OK
        );
    }

    @GetMapping( "/{question-id}")
    @Operation(summary = "get all questions related to given id", description = "You can read all information about questions that the id of the question equals to given id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<QuestionGetDTO> getByID(@Parameter(description="The entered question id cannot be empty.", required=true)
                                                  @PathVariable("question-id") int questionId) {
        return new ResponseEntity<>(
                questionService.getQuestion(questionId),
                HttpStatus.OK
        );
    }

    @PostMapping
    @Operation(summary = "add a question", description = "You can add any type of question.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<Integer> addQuestion(@Parameter(description="Request body cannot be empty.", required=true)
                                               @RequestBody QuestionPostDTO questionPostDTO)
    {
               return new ResponseEntity<>(
                 questionService.addQuestion(questionPostDTO),
                 HttpStatus.CREATED
               );
    }

    @PostMapping("/{question-id}/answers")
    @Operation(summary = "add an answer", description = "You can add any type of answer.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<HashMap<String, Integer>> addAnswerToQuestion(@Parameter(description="The entered question id cannot be empty.", required=true)
                                                                        @PathVariable("question-id") int questionId,
                                                                        @Parameter(description="Request body cannot be empty.", required=true)
                                                                        @RequestBody AnswerPostDTO answerPostDTO) {
        return new ResponseEntity<>(
                questionService.addAnswer(questionId, answerPostDTO),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/{question-id}/comments")
    @Operation(summary = "add a comment to a question", description = "You can add any type of comment to a question.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<HashMap<String, Integer>> addCommentToQuestion(@Parameter(description="The entered question id cannot be empty.", required=true)
                                                                         @PathVariable("question-id") int questionId,
                                                                         @Parameter(description="Request body cannot be empty.", required=true)
                                                                         @RequestBody CommentPostDTO commentPostDTO) {
        return new ResponseEntity<>(
                questionService.addCommentToQuestion(questionId, commentPostDTO),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/{question-id}/answers/{answer-id}/comments")
    @Operation(summary = "add a comment to an answer", description = "You can add any type of comment to an answer.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<HashMap<String, Integer>> addCommentToAnswer(@Parameter(description="The entered question id and answer id cannot be empty.", required=true)
                                                                       @PathVariable("answer-id") int answerId,
                                                                       @Parameter(description="Request body cannot be empty.", required=true)
                                                                       @RequestBody CommentPostDTO commentPostDTO) {
        return new ResponseEntity<>(
                questionService.addCommentToAnswer(answerId, commentPostDTO),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{question-id}")
    @Operation(summary = "vote a question", description = "You can vote any question you like.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<Integer> votingQuestion(@Parameter(description="The entered question id cannot be empty.", required=true)
                                                  @PathVariable("question-id") Integer questionId) {
        return new ResponseEntity<>(
                questionService.voteQuestion(questionId),
                HttpStatus.OK
        );
    }

    @PutMapping("/{question-id}/answers/{answer-id}")
    @Operation(summary = "vote an answer", description = "You can vote any answer you like.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<Integer> votingAnswer(@Parameter(description="The entered question id and answer id cannot be empty.", required=true)
                                                @PathVariable("answer-id") Integer answerId) {
        return new ResponseEntity<>(
                questionService.voteAnswer(answerId),
                HttpStatus.OK
        );
    }

    @PutMapping("/comments/{comment-id}")
    @Operation(summary = "vote a comment", description = "You can vote any comment you like.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<Integer> votingComment(@Parameter(description="The entered comment id cannot be empty.", required=true)
                                                 @PathVariable("comment-id") Integer commentId) {
        return new ResponseEntity<>(
                questionService.voteComment(commentId),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/comments/{comment-id}")
    @Operation(summary = "delete a comment", description = "You can delete any comment you want.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<Integer> deleteComment(@Parameter(description="The entered comment id cannot be empty.", required=true)
                                                 @PathVariable("comment-id") Integer commentId) {
        return new ResponseEntity<>(
                questionService.deleteComment(commentId),
                HttpStatus.OK
        );
    }

    @PutMapping("/answers/update/{answer-id}")
    @Operation(summary = "change an answer", description = "You can change any answer you want.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<Integer> updateAnswer(@Parameter(description="The entered answer id cannot be empty.", required=true)
                                                @PathVariable("answer-id") Integer answerId,
                                                @Parameter(description="Request body cannot be empty.", required=true)
                                                @RequestBody String answerText) {
        return new ResponseEntity<>(
                questionService.updateAnswer(answerId, answerText),
                HttpStatus.OK
        );
    }

    @PutMapping("/comments/update/{comment-id}")
    @Operation(summary = "change a comment", description = "You can change any comment you want.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"),
                           @ApiResponse(responseCode = "404", description = "Not Found"),
                           @ApiResponse(responseCode = "400", description = "Bad Request"),
                           @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<Integer> updateComment(@Parameter(description="The entered comment id cannot be empty.", required=true)
                                                 @PathVariable("comment-id") Integer commentId,
                                                 @Parameter(description="Request body cannot be empty.", required=true)
                                                 @RequestBody String commentText) {
        return new ResponseEntity<>(
                questionService.updateComment(commentId, commentText),
                HttpStatus.OK
        );
    }
}
