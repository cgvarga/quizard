package org.quizard.services.service;

import java.util.List;

import javax.transaction.Transactional;

import org.quizard.services.domain.Answer;
import org.quizard.services.domain.Question;
import org.quizard.services.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public Iterable<Question> save(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }

    public Iterable<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public String delete(Long id) {
        questionRepository.deleteById(id);
        return "deleted question " + id;
    }

    public Question update(Question question) {
        Question existingQuestion = questionRepository.findById(question.getId()).orElse(null);
        if (existingQuestion != null) {

            existingQuestion.setValue(question.getValue());
            existingQuestion.setAnswers(question.getAnswers());
            questionRepository.save(existingQuestion);
            return existingQuestion;
        }
        return null;

    }
}
