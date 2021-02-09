package io.tpalucki.grammati.questionimporter;


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

    @Override
    public void run(String... args) throws Exception {
        log.info("ApplicationRunner started");

        template.execute("INSERT INTO quiz (session_id) VALUES ('a86sd76asdasd6a')");
    }
}
