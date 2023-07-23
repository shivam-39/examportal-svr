package com.nash.examportal.service;

import com.nash.examportal.model.Quiz;

import java.util.List;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public List<Quiz> getAllQuiz();

    public Quiz getQuiz(Long qId);

    public void deleteQuiz(Long qId);

    List<Quiz> getQuizByCategory(Long cId);

    public List<Quiz> getQuizByActive();

    public List<Quiz> getQuizByCategoryAndActive(Long cId);
}
