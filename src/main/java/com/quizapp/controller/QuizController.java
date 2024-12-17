package com.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.dto.AnswerRequest;
import com.quizapp.dto.StatsDisplay;
import com.quizapp.model.Question;
import com.quizapp.model.QuizSession;
import com.quizapp.repository.QuizSessionRepository;
import com.quizapp.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
	
    @Autowired
    private QuizService quizService;
    
    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @PostMapping("/start")
    public QuizSession startQuiz() {
        return quizService.startQuizSession();
    }

    @GetMapping("/question/{sessionId}")
    public Question getRandomQuestion(@PathVariable Long sessionId) {
        QuizSession session = quizService.getQuizSession(sessionId);
        Question question = quizService.getRandomQuestion();
        session.setCurrentQuestion(question);
        session = quizSessionRepository.save(session);
        return question;
    }

    @PostMapping("/answer/{sessionId}")
    public ResponseEntity<String> submitAnswer(@PathVariable Long sessionId, @RequestBody AnswerRequest request) {
    	
        QuizSession session = quizService.getQuizSession(sessionId);
        if (session == null) {
            return ResponseEntity.badRequest().body("Invalid session ID");
        }

        Question question = session.getCurrentQuestion();
        if (question == null) {
            return ResponseEntity.internalServerError().body("Question not found");
        }

        boolean isCorrect = quizService.submitAnswer(session, request.getAnswerIndex(), question);

        return ResponseEntity.ok(isCorrect ? "Correct!" : "Incorrect!");
    }

    @GetMapping("/stats/{sessionId}")
    public StatsDisplay getQuizStats(@PathVariable Long sessionId) {
        QuizSession session = quizService.getQuizSession(sessionId);
        StatsDisplay stats = new StatsDisplay();
        stats.setId(session.getId());
        stats.setTotalAnswerd(session.getTotalAnswerd());
        stats.setCorrectAnswers(session.getCorrectAnswers());
        stats.setIncorrectAnswers(session.getIncorrectAnswers());
        return stats;
    }
}
