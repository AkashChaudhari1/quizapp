package com.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizapp.model.QuizSession;

@Repository
public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {
}
