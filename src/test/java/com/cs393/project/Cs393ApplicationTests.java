package com.cs393.project;

import com.cs393.project.model.*;
import com.cs393.project.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class Cs393ApplicationTests {

	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	TagRepository tagRepository;
	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
		Question question = new Question();
		question.setTitle("Spring-Boot: How can I set the logging level with application.properties?");
		question.setDescription("This is very simple question, but I cannot find information.\n" +
				"(Maybe my knowledge about Java frameworks is severely lacking)\n" +
				"\n" +
				"How can I set the logging level with application.properties?\n" +
				"And logging file location, etc?");
		question.setAskedDate(new Date());
		question.setVoteCount(378);
		question.setAnswerCount(18);


		Tag tag1 = new Tag();
		tag1.setTag("spring-boot");

		Tag tag2 = new Tag();
		tag2.setTag("logging");

		tag1.getQuestions().add(question);
		tag2.getQuestions().add(question);

		question.getTags().add(tag1);
		question.getTags().add(tag2);

		User user1 = new User();
		user1.setUsername("zeodtr");

		User user2 = new User();
		user2.setUsername("M. Deinum");

		user1.getQuestions().add(question);
		question.setUser(user1);

		Answer answer = new Answer();
		answer.setQuestion(question);
		answer.setUser(user2);
		user2.getAnswers().add(answer);
		answer.setText("Update: Starting with Spring Boot v1.2.0.RELEASE, the settings in application.properties or application.yml do apply. " +
				"See the Log Levels section of the reference guide.\n" +
				"\n" +
				"logging.level.org.springframework.web: DEBUG\n" +
				"logging.level.org.hibernate: ERROR\n" +
				"\nFor earlier versions of Spring Boot you cannot. You simply have to use the normal configuration for your logging framework " +
				"(log4j, logback) for that. Add the appropriate config file (log4j.xml or logback.xml) to the src/main/resources " +
				"directory and configure to your liking.\n" +
				"\n" +
				"You can enable debug logging by specifying --debug when starting the application from the command-line.\n" +
				"\n" +
				"Spring Boot provides also a nice starting point for logback to configure some defaults, coloring etc. the base.xml file which " +
				"you can simply include in your logback.xml file. (This is also recommended from the default logback.xml in Spring Boot.\n" +
				"\n" +
				"<include resource=\"org/springframework/boot/logging/logback/base.xml\"/>");
		answer.setAnswerDate(new Date());
		answer.setVoteCount(428);

		question.getAnswers().add(answer);

		User user3 = new User();
		user3.setUsername("Dave Syer");

		User user4 = new User();
		user4.setUsername("LukeSolar");

		Comment comment1 = new Comment();
		comment1.setAnswer(answer);
		comment1.setUser(user3);
		comment1.setText("Normally anything that you can do on the command line works in an external config file." +
				"So debug=true would do it I think. That flag is a little bit special because the logging has to be " +
				"initialized very early, but I think that would work.");
		comment1.setCommentDate(new Date());
		comment1.setVoteCount(13);
		user3.getComments().add(comment1);
		answer.getComments().add(comment1);
		Comment comment2 = new Comment();
		comment2.setQuestion(question);
		comment2.setText("For the record, another option is to set the log level as environment variable, " +
				"for example via the heroku dashboard. In Settings -> Config Vars set logging.level.com.yourpackage " +
				"to the desired level (INFO, ERROR, DEBUG).");
		comment2.setCommentDate(new Date());
		comment2.setUser(user4);
		comment2.setVoteCount(31);
		user4.getComments().add(comment2);
		question.getComments().add(comment2);

		tagRepository.save(tag1);
		tagRepository.save(tag2);
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		questionRepository.save(question);
		answerRepository.save(answer);
		commentRepository.save(comment1);
		commentRepository.save(comment2);
	}
}
