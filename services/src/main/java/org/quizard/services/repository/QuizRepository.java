package org.quizard.services.repository;

import org.quizard.services.domain.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
