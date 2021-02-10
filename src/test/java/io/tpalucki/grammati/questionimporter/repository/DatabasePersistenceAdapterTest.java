package io.tpalucki.grammati.questionimporter.repository;

import io.tpalucki.grammati.questionimporter.model.Question;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class DatabasePersistenceAdapterTest {

    @Test
    void shouldPersistToDatabase() {
        DatabaseQuestionRepository mockedRepository = mock(DatabaseQuestionRepository.class);
        PersistenceAdapter unit = new DatabasePersistenceAdapter(mockedRepository);
        final List<Question> input = List.of();

        unit.persist(input);

        verify(mockedRepository, times(1)).saveAll(input);
    }


    // TODO false positive test - fix
    @Test
    void shouldNotPersistWhenNullPassed() {
        DatabaseQuestionRepository mockedRepository = mock(DatabaseQuestionRepository.class);
        PersistenceAdapter unit = new DatabasePersistenceAdapter(mockedRepository);

        unit.persist(null);

        verify(mockedRepository, times(0)).saveAll(notNull());
    }

}