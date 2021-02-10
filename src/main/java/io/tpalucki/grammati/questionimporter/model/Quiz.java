package io.tpalucki.grammati.questionimporter.model;

import io.tpalucki.grammati.questionimporter.provider.csv.model.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quiz")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    private String sessionId;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.PERSIST)
    private List<Question> questions = new ArrayList<>();
}
