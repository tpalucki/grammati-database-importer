package io.tpalucki.grammati.questionimporter.provider;

import io.tpalucki.grammati.questionimporter.model.Question;

import java.io.FileNotFoundException;
import java.util.List;

public interface QuestionModelProvider {

    List<Question> provide() throws FileNotFoundException;
}
