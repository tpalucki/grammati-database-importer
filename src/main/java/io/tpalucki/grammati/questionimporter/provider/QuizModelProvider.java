package io.tpalucki.grammati.questionimporter.provider;

import io.tpalucki.grammati.questionimporter.model.Quiz;

import java.io.FileNotFoundException;
import java.util.List;

public interface QuizModelProvider {

    List<Quiz> provide() throws FileNotFoundException;
}
