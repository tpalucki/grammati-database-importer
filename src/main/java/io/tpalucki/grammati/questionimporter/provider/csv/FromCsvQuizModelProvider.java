package io.tpalucki.grammati.questionimporter.provider.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import io.tpalucki.grammati.questionimporter.model.Quiz;
import io.tpalucki.grammati.questionimporter.provider.QuizModelProvider;
import io.tpalucki.grammati.questionimporter.provider.csv.model.Question;
import io.tpalucki.grammati.questionimporter.provider.csv.model.QuizCsvRow;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;


@Component
@Log
public class FromCsvQuizModelProvider implements QuizModelProvider {

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


                    var quiz = Quiz.builder()
                            .sessionId("a768a6s7d6a87sd---------asdasdasd")
                            .build();

                    quiz.setQuestions(List.of(Question.builder()
                            .question("AAAAAAAAAAAAAAAAAA")
                            .quiz(quiz)
                            .build()));

                    return quiz;
                })
                .collect(Collectors.toList());
    }

}