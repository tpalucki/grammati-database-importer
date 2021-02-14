package io.tpalucki.grammati.questionimporter.provider.csv;

import io.tpalucki.grammati.questionimporter.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class FromCsvQuestionModelProviderTest {

    private FromCsvQuestionModelProvider provider;

    @BeforeEach
    void setUp() {
        provider = new FromCsvQuestionModelProvider();
        provider.setFileName("testInput.csv");
    }

    @Test
    void shouldProvideQuestionsList() throws FileNotFoundException {
        final List<Question> provided = provider.provide();

        assertThat(provided).isNotNull().hasSize(2);

        var question = provided.get(0);

        assertThat(question).isNotNull();
        assertThat(question.getLevel()).isEqualTo("a1");
        assertThat(question.getQuestion()).isEqualTo("I ___ a student.");
        assertThat(question.getTopic()).isEqualTo("to be");
        assertThat(question.getTipEng()).isEqualTo("The verb “to be” is irregular.");
        assertThat(question.getAnswers()).isNotNull().hasSize(2);

        var answer = question.getAnswers().get(0);
        assertThat(answer.getAnswerText()).isEqualTo("am");
        assertThat(answer.isCorrect()).isEqualTo(true);

        answer = question.getAnswers().get(1);
        assertThat(answer.getAnswerText()).isEqualTo("is");
        assertThat(answer.isCorrect()).isEqualTo(false);

    }

}