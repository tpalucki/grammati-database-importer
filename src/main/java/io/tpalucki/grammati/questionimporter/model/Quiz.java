package io.tpalucki.grammati.questionimporter.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "quiz")
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    private String sessionId;
}
