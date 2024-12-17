package com.quizapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.model.Question;
import com.quizapp.model.QuizSession;
import com.quizapp.repository.QuestionRepository;
import com.quizapp.repository.QuizSessionRepository;

@Service
public class QuizService {
	
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private QuizSessionRepository quizSessionRepository;
      
    private static Map<String, QuizSession> sessions = new HashMap<>();
    
    public QuizSession startQuizSession() {
        QuizSession session = new QuizSession();
        session.setTotalQuestions(questionRepository.findAll().size());
        session = quizSessionRepository.save(session);
        return session;
    }

    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            return null;
        }
        int randomIndex = new Random().nextInt(questions.size());
        return questions.get(randomIndex);
    }

    public boolean submitAnswer(QuizSession session, int answerIndex, Question question) {
        boolean isCorrect = answerIndex == question.getCorrectAnswerIndex();
        if (isCorrect) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
        }
        session.setTotalAnswerd(session.getCorrectAnswers()+session.getIncorrectAnswers());
        quizSessionRepository.save(session);
        return isCorrect;
    }
    
    public QuizSession getQuizSession(Long sessionId) {
        return quizSessionRepository.findById(sessionId).orElse(null);
    }
}
