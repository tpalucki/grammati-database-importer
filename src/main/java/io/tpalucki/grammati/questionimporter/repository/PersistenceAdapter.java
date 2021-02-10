package io.tpalucki.grammati.questionimporter.repository;

import io.tpalucki.grammati.questionimporter.model.Question;

public interface PersistenceAdapter {

    void persist(Iterable<Question> model);
}
