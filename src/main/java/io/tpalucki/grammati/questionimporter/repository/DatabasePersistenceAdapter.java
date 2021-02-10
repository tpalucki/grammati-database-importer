package io.tpalucki.grammati.questionimporter.repository;

import io.tpalucki.grammati.questionimporter.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabasePersistenceAdapter implements PersistenceAdapter {

    private final DatabaseQuestionRepository questionRepository;

    public void persist(Iterable<Question> provide) {
        questionRepository.saveAll(provide);
    }
}
