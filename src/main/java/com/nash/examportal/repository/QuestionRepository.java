package com.nash.examportal.repository;

import com.nash.examportal.model.Question;
import com.nash.examportal.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
//    @Query("SELECT q FROM QUESTION q WHERE q.QUIZ_Q_ID = :qId")
//    public List<Question> findByQuiz(Long qId);
}
