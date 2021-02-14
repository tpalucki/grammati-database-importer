package io.tpalucki.grammati.questionimporter.provider.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import io.tpalucki.grammati.questionimporter.model.Answer;
import io.tpalucki.grammati.questionimporter.model.Question;
import io.tpalucki.grammati.questionimporter.provider.QuestionModelProvider;
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
public class FromCsvQuestionModelProvider implements QuestionModelProvider {

    @Override
    public List<Question> provide() throws FileNotFoundException {
        var fileName = "./zdania.csv";
        var file = this.getClass().getClassLoader().getResource(fileName).getFile();
        var csvToBeanBuilder = new CsvToBeanBuilder(new FileReader(file))
                .withType(QuizCsvRow.class)
                .withSeparator(',')
                .build();

        List<QuizCsvRow> rows = csvToBeanBuilder.parse();

        return rows
                .stream()
                .map(row -> {
                    log.info(row.toString());

                    var question = new Question();
                    question.setQuestion(row.getSentence());
                    question.setLevel(row.getLevel());
                    question.setTopic(row.getTopic());
                    question.setTipEng(row.getTipEng());
                    question.setTipPl(row.getTipPl());

                    List<Answer> answers = new ArrayList<>();

                    var ans1 = new Answer();
                    ans1.setAnswerText(row.getCorrectAnswer());
                    ans1.setCorrect(true);
                    ans1.setQuestion(question);

                    answers.add(ans1);

                    if (nonNull(row.getIncorrectAnswer1()) && !row.getIncorrectAnswer1().isBlank()) {
                        var ans2 = new Answer();
                        ans2.setAnswerText(row.getIncorrectAnswer1());
                        ans2.setCorrect(false);
                        ans2.setQuestion(question);

                        answers.add(ans2);
                    }

                    if (nonNull(row.getIncorrectAnswer2()) && !row.getIncorrectAnswer2().isBlank()) {
                        var ans3 = new Answer();
                        ans3.setAnswerText(row.getIncorrectAnswer2());
                        ans3.setCorrect(false);
                        ans3.setQuestion(question);

                        answers.add(ans3);
                    }

                    if (nonNull(row.getIncorrectAnswer3()) && !row.getIncorrectAnswer3().isBlank()) {
                        var ans4 = new Answer();
                        ans4.setAnswerText(row.getCorrectAnswer());
                        ans4.setCorrect(false);
                        ans4.setQuestion(question);

                        answers.add(ans4);
                    }

                    question.setAnswers(answers);

                    log.info("Generated question: " + question);
                    return question;
                })
                .collect(Collectors.toList());
    }

}