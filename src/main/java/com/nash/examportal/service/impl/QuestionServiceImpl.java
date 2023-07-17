package com.nash.examportal.service.impl;

import com.nash.examportal.model.Question;
import com.nash.examportal.model.Quiz;
import com.nash.examportal.repository.QuestionRepository;
import com.nash.examportal.service.QuestionService;
import com.nash.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuizService quizService;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestion() {
        return this.questionRepository.findAll();
    }

//    @Override
//    public List<Question> getQuestionByQuiz(Long qId) {
//        return this.questionRepository.findByQuiz(qId);
//    }

    @Override
    public List<Question> getQuestionWithNumberOfQuesInQuiz(Long qId) {
        Quiz quiz = this.quizService.getQuiz(qId);
        List<Question> questionList= new ArrayList<>(quiz.getQuestionSet());
        Collections.shuffle(questionList);
        if (questionList.size() > Integer.parseInt(quiz.getNumberOfQues())) {
            questionList = questionList.subList(0, Integer.parseInt(quiz.getNumberOfQues()));
        }
        return questionList;
    }

    @Override
    public Question getQuestion(Long qId) {
        return this.questionRepository.findById(qId).get();
    }

    @Override
    public void deleteQuestion(Long qId) {
        this.questionRepository.deleteById(qId);
    }

}
