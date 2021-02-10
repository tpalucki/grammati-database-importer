package io.tpalucki.grammati.questionimporter;


import io.tpalucki.grammati.questionimporter.provider.QuestionModelProvider;
import io.tpalucki.grammati.questionimporter.repository.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log
@RequiredArgsConstructor
public class ApplicationRunner implements CommandLineRunner {

    private final PersistenceAdapter persistenceAdapter;
    private final QuestionModelProvider modelProvider;

    @Override
    public void run(String... args) throws Exception {
        log.info("ApplicationRunner started");
        persistenceAdapter.persist(modelProvider.provide());
    }
}
