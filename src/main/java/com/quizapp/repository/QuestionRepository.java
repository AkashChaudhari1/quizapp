package com.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizapp.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
