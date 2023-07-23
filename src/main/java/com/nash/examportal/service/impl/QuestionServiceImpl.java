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
import java.util.Map;

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

    @Override
    public List<Question> getAllQuestionByQuiz(Long qId) {
        Quiz quiz = new Quiz();
        quiz.setQId(qId);
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public List<Question> getQuestionByQuiz(Long qId) {
        Quiz quiz = this.quizService.getQuiz(qId);
        List<Question> questionList= new ArrayList<>(quiz.getQuestionSet());
        Collections.shuffle(questionList);
        if (questionList.size() > Integer.parseInt(quiz.getNumberOfQues())) {
            questionList = questionList.subList(0, Integer.parseInt(quiz.getNumberOfQues()));
        }
        questionList.forEach(q->{
            q.setAnswer(null);
        });
        return questionList;
    }

    @Override
    public Map<String, Double> evaluateQuiz(List<Question> questionList) {
        Double correctAnswer = Double.parseDouble("0");
        Double marksGot = Double.parseDouble("0");
        Double quesAttempted = Double.parseDouble("0");
        for (Question question:questionList){
            Question correctQuestion = this.getQuestion(question.getQuesId());
            if (correctQuestion.getAnswer().equals(question.getGivenAnswer())) {
                correctAnswer += 1;
                Double sinleQuesMarks = Double.parseDouble(question.getQuiz().getMaxMarks())/Double.parseDouble(String.valueOf(questionList.size()));
                marksGot += sinleQuesMarks;
                quesAttempted += 1;
            } else if (question.getAnswer() != null){
                quesAttempted += 1;
            }
            marksGot = Math.round(marksGot * 100)/ 100.0;
        }
        Map<String, Double> responseMap = Map.of("marksGot",marksGot, "correctAnswer", correctAnswer, "quesAttempted", quesAttempted);
        return responseMap;
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
