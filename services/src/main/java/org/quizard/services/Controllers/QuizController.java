package org.quizard.services.controllers;

import java.util.List;

import org.quizard.services.domain.Quiz;
import org.quizard.services.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quizes")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/add-quiz")
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return quizService.addQuiz(quiz);
    }

    @PostMapping("/add-quizes")
    public Iterable<Quiz> addQuizes(@RequestBody List<Quiz> quizes) {
        return quizService.addQuizes(quizes);
    }

    @GetMapping("")
    public Iterable<Quiz> getQuizes() {
        return quizService.getQuizes();
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@RequestParam Long id) {
        return quizService.getQuizById(id);
    }

}
