package com.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalQuestions;
    private int totalAnswerd;
    private int correctAnswers;
    private int incorrectAnswers;
    @ManyToOne(fetch = FetchType.EAGER)
    private Question currentQuestion;
}
