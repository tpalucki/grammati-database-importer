package io.tpalucki.grammati.questionimporter.repository;

import io.tpalucki.grammati.questionimporter.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseQuestionRepository extends JpaRepository<Question, Long> {

}
