package io.tpalucki.grammati.questionimporter.repository;

import io.tpalucki.grammati.questionimporter.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseQuizRepository extends JpaRepository<Quiz, Long> {

}
