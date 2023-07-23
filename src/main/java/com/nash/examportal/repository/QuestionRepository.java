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

//    @Query("SELECT q.ques_id, q.content, q.image, q.option1, q.option2, q.option3, q.option4, q.answer, b.q_id, b.title, b.description, b.max_marks, b.number_of_ques, b.active FROM question q, quiz b WHERE b.q_id = q.quiz_q_id and q.quiz_q_id = :qId")
//    public List<Question> findByQuiz(Long qId);

    public List<Question> findByQuiz(Quiz quiz);
}
