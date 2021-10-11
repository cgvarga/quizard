package org.quizard.services.service;

import java.util.List;

import org.quizard.services.domain.Answer;
import org.quizard.services.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository repository;

    public Answer saveAnswer(Answer answer) {
        return repository.save(answer);
    }

    public Iterable<Answer> saveAnswers(List<Answer> answers) {
        return repository.saveAll(answers);
    }

    public Answer getAnswer(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Answer updateAnswer(Answer answer) {
        Answer existingAnswer = repository.findById(answer.getId()).orElse(null);
        if (existingAnswer != null) {
            existingAnswer.setCorrect(answer.getCorrect());
            existingAnswer.setValue(answer.getValue());
            return repository.save(existingAnswer);
        }
        return null;
    }

    public String deleteAnswer(Answer answer) {
        repository.delete(answer);
        return "deleted answer " + answer.getId();
    }
}
