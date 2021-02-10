package io.tpalucki.grammati.questionimporter;


import io.tpalucki.grammati.questionimporter.provider.QuizModelProvider;
import io.tpalucki.grammati.questionimporter.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log
@RequiredArgsConstructor
public class ApplicationRunner implements CommandLineRunner {

    private final QuizRepository repository;
    private final QuizModelProvider modelProvider;

    @Override
    public void run(String... args) throws Exception {
        log.info("ApplicationRunner started");

        // odczytujemy plik csv - możemy kiedyś zmienić źródło
        // zapisujemy do bazy danych - również możemy kiedyś zmienić śródło

        repository.saveAll(modelProvider.provide());
    }
}
