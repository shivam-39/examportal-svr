package com.nash.examportal.service.impl;

import com.nash.examportal.model.Category;
import com.nash.examportal.model.Quiz;
import com.nash.examportal.repository.QuizRepository;
import com.nash.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return this.quizRepository.findAll();
    }

    @Override
    public Quiz getQuiz(Long qId) {
        return this.quizRepository.findById(qId).get();
    }

    @Override
    public void deleteQuiz(Long qId) {
        this.quizRepository.deleteById(qId);
    }

    @Override
    public List<Quiz> getQuizByCategory(Long cId) {
        Category category = new Category();
        category.setCId(cId);
        return this.quizRepository.findByCategory(category);
    }

    @Override
    public List<Quiz> getQuizByActive(){
        return this.quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getQuizByCategoryAndActive(Long cId){
        Category category = new Category();
        category.setCId(cId);
        return this.quizRepository.findByCategoryAndActive(category, true);
    }

}
