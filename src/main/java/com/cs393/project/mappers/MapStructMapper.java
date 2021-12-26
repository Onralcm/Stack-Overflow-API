package com.cs393.project.mappers;

import com.cs393.project.dao.AnswerPostDTO;
import com.cs393.project.dao.CommentPostDTO;
import com.cs393.project.dao.QuestionGetDTO;
import com.cs393.project.dao.QuestionPostDTO;
import com.cs393.project.model.Answer;
import com.cs393.project.model.Comment;
import com.cs393.project.model.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    List<QuestionGetDTO> questionsToQuestionsGetDTO(List<Question> question);

    QuestionGetDTO questionToQuestionGetDTO(Question question);

    Question questionPostDTOToQuestion(QuestionPostDTO questionPostDTO);

    Answer answerPostDTOtoAnswer(AnswerPostDTO answerPostDTO);

    Comment commentQuestionPostDTOtoComment(CommentPostDTO commentPostDTO);


}
