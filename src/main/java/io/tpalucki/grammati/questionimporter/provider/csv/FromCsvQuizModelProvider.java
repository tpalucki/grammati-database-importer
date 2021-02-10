package io.tpalucki.grammati.questionimporter.provider.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import io.tpalucki.grammati.questionimporter.model.Answer;
import io.tpalucki.grammati.questionimporter.model.Question;
import io.tpalucki.grammati.questionimporter.model.Quiz;
import io.tpalucki.grammati.questionimporter.provider.QuizModelProvider;
import io.tpalucki.grammati.questionimporter.provider.csv.model.QuizCsvRow;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;


@Component
@Log
public class FromCsvQuizModelProvider implements QuizModelProvider {

    private final static String EMPTY_SESSION_ID = "";

    @Override
    public List<Quiz> provide() throws FileNotFoundException {
        var fileName = "./zdania.csv";
        var file = this.getClass().getClassLoader().getResource(fileName).getFile();
        var csvToBeanBuilder = new CsvToBeanBuilder(new FileReader(file))
                .withType(QuizCsvRow.class)
                .withSeparator(',')
                .build();

        List<QuizCsvRow> rows = csvToBeanBuilder.parse();

        // Converting quiz to model classes
        return rows
                .stream()
                .map(row -> {
                    log.info(row.toString());
                    var quiz = new Quiz();
                    quiz.setSessionId(EMPTY_SESSION_ID);

                    var question = new Question();
                    question.setQuestion(row.getSentence());
                    question.setQuiz(quiz);

                    quiz.setQuestions(List.of(question));

                    List<Answer> answers = new ArrayList<>();

                    var ans1 = new Answer();
                    ans1.setAnswerText(row.getCorrectAnswer());
                    ans1.setCorrect(true);
                    ans1.setQuestion(question);

                    answers.add(ans1);

                    if (nonNull(row.getIncorrectAnswer1())) {
                        var ans2 = new Answer();
                        ans2.setAnswerText(row.getIncorrectAnswer1());
                        ans2.setCorrect(false);
                        ans2.setQuestion(question);

                        answers.add(ans2);
                    }

                    if (nonNull(row.getIncorrectAnswer2())) {
                        var ans3 = new Answer();
                        ans3.setAnswerText(row.getIncorrectAnswer2());
                        ans3.setCorrect(false);
                        ans3.setQuestion(question);

                        answers.add(ans3);
                    }

                    if (nonNull(row.getIncorrectAnswer3())) {
                        var ans4 = new Answer();
                        ans4.setAnswerText(row.getCorrectAnswer());
                        ans4.setCorrect(false);
                        ans4.setQuestion(question);

                        answers.add(ans4);
                    }

                    question.setAnswers(answers);

                    log.info("Quiz object: " + quiz);
                    return quiz;
                })
                .collect(Collectors.toList());
    }

}