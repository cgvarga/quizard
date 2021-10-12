package org.quizard.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.quizard.services.domain.Answer;
import org.quizard.services.domain.Question;
import org.quizard.services.domain.Quiz;
import org.quizard.services.service.QuizService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}


	//populate DB with default data
	@Bean
	CommandLineRunner runner(QuizService quizService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();

			TypeReference<List<Quiz>> typeReference = new TypeReference<List<Quiz>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/QuestionsDB.json");

			try {
				List<Quiz> quizes = mapper.readValue(inputStream, typeReference);
				quizService.addQuizes(quizes);
				System.out.println("Quiz saved");
			} catch (IOException err) {
				System.out.println("Unable to save Quiz: " + err.getMessage());
			}
		};
	}

	//Populate single question with a few answers.
	/* @Bean
	CommandLineRunner runner(QuestionService questionService, AnswerService answerService) {
		return args -> {
			Question question = new Question();
			question.setValue("Who plays Iron Man?");
			List<Answer> answers = new ArrayList<>();
			answers.add(new Answer("Chris Evans", false));
			answers.add(new Answer("Robert Downy Jr", true));
			answers.add(new Answer("Mark Ruffalo", false));

			question.setAnswers(answers);

			questionService.save(question);
		};
	} */

}
