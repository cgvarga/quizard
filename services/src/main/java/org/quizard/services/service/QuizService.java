package org.quizard.services.service;

import java.util.List;

import javax.transaction.Transactional;

import org.quizard.services.domain.Quiz;
import org.quizard.services.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }
    public Iterable<Quiz> addQuizes(List<Quiz> quizes) {
        return quizRepository.saveAll(quizes);
    }
    public Iterable<Quiz> getQuizes() {
        return quizRepository.findAll();
    }
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }
}
