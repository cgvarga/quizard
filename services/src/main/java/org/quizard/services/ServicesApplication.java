package org.quizard.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.quizard.services.domain.Answer;
import org.quizard.services.domain.Question;
import org.quizard.services.service.AnswerService;
import org.quizard.services.service.QuestionService;
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
	CommandLineRunner runner(QuestionService questionService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();

			TypeReference<List<Question>> typeReference = new TypeReference<List<Question>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/QuestionsDB.json");

			try {
				List<Question> questions = mapper.readValue(inputStream, typeReference);
				questionService.save(questions);
				System.out.println("Questions saved");
			} catch (IOException err) {
				System.out.println("Unable to save questions: " + err.getMessage());
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
