package io.tpalucki.grammati.questionimporter.provider.csv.model;

import io.tpalucki.grammati.questionimporter.model.Quiz;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "question")
@Data
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

}
