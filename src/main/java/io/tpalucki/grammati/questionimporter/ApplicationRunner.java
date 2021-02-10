package io.tpalucki.grammati.questionimporter;


import io.tpalucki.grammati.questionimporter.provider.QuestionModelProvider;
import io.tpalucki.grammati.questionimporter.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log
@RequiredArgsConstructor
public class ApplicationRunner implements CommandLineRunner {

    private final QuestionRepository repository;
    private final QuestionModelProvider modelProvider;

    @Override
    public void run(String... args) throws Exception {
        log.info("ApplicationRunner started");

        // odczytujemy plik csv - możemy kiedyś zmienić źródło
        // zapisujemy do bazy danych - również możemy kiedyś zmienić źródło

        repository.saveAll(modelProvider.provide());
    }
}
