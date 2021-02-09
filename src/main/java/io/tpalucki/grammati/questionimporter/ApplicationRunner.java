package io.tpalucki.grammati.questionimporter;


import io.tpalucki.grammati.questionimporter.model.Quiz;
import io.tpalucki.grammati.questionimporter.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Log
@RequiredArgsConstructor
public class ApplicationRunner implements CommandLineRunner {

    private final JdbcTemplate template;
    private final QuizRepository repository;


    @Override
    public void run(String... args) throws Exception {
        log.info("ApplicationRunner started");

        // odczytujemy plik csv - możemy kiedyś zmienić źródło
        // zapisujemy do bazy danych - również możemy kiedyś zmienić śródło


        template.execute("INSERT INTO quiz (session_id) VALUES ('a86sd76asdasd6a')");

        var quiz = new Quiz();
        quiz.setSessionId("aaaaaaaaaa6876a786sd6a78s6d87a7");
        repository.save(quiz);
    }
}
