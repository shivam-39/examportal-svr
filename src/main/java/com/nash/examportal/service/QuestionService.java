package com.nash.examportal.service;

import com.nash.examportal.model.Question;
import com.nash.examportal.model.Quiz;

import java.util.List;
import java.util.Map;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public List<Question> getAllQuestion();

    public List<Question> getAllQuestionByQuiz(Long qId);

    public Question getQuestion(Long qId);

    public void deleteQuestion(Long qId);

    public List<Question> getQuestionByQuiz(Long qId);

    Map<String, Double> evaluateQuiz(List<Question> questionList);
}
