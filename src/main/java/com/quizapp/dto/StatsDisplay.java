package com.quizapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatsDisplay {
	private Long id;
	private int totalAnswerd;
    private int correctAnswers;
    private int incorrectAnswers;
}
