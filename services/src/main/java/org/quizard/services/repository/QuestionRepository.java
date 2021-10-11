package org.quizard.services.repository;

import org.quizard.services.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    
}
