package org.quizard.services.controllers;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.quizard.services.service.AnswerService;
import org.quizard.services.service.QuestionService;
import org.quizard.services.domain.Question;
import org.quizard.services.domain.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    private QuestionService questionService;

    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("add-question")
    @Transactional
    public Question addQuestion(@RequestBody Question question) {
        return questionService.save(question);
    }

    @PostMapping("add-questions")
    public Iterable<Question> addQuestions(@RequestBody ArrayList<Question> questions) {
        return questionService.save(questions);
    }

    @GetMapping("")
    public Iterable<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    /* @PutMapping("/{id}")
    public Question updatQuestion(@RequestBody Question question) {
        return questionService.update(question);
    } */

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        return questionService.delete(id);
    }

}
