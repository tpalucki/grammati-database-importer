package io.tpalucki.grammati.questionimporter.provider.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import io.tpalucki.grammati.questionimporter.model.Quiz;
import io.tpalucki.grammati.questionimporter.provider.QuizModelProvider;
import io.tpalucki.grammati.questionimporter.provider.csv.model.QuizCsvRow;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
@Log
public class FromCsvQuizModelProvider implements QuizModelProvider {

    @Override
    public List<Quiz> provide() throws FileNotFoundException {
        var fileName = "zdania.csv";

        List rows = new CsvToBeanBuilder(new FileReader(fileName)).withType(QuizCsvRow.class).build().parse();

        log.info("Read rows: " + rows);
        return null;
    }
}
