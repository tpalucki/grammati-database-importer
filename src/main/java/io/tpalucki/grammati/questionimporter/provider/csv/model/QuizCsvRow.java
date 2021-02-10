package io.tpalucki.grammati.questionimporter.provider.csv.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class QuizCsvRow {

    @CsvBindByName
    private Long id;
    @CsvBindByName(column = "poziom")
    private String level;
    @CsvBindByName(column = "Zdanie")
    private String sentence;
    @CsvBindByName(column = "Zagadnienie")
    private String topic;
    @CsvBindByName(column = "TIP ENG")
    private String tipEng;
    @CsvBindByName(column = "TIP PL")
    private String tipPl;
    @CsvBindByName(column = "Correct")
    private String correctAnswer;
    @CsvBindByName(column = "Incorrect")
    private String incorrectAnswer1;
    @CsvBindByName(column = "Incorrect 2")
    private String incorrectAnswer2;
    @CsvBindByName(column = "Incorrect 3")
    private String incorrectAnswer3;

}
