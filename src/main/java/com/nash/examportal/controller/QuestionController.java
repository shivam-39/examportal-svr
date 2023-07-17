package com.nash.examportal.controller;

import com.nash.examportal.model.Question;
import com.nash.examportal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    //addQuestion
    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //updateQuestion
    @PutMapping("/")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //getAllQuestion
    @GetMapping("/")
    public ResponseEntity<?> getAllQuestion(){
        return ResponseEntity.ok(this.questionService.getAllQuestion());
    }

    //getQuestionByQuiz
//    @GetMapping("/quiz-ques/{qId}")
//    public ResponseEntity<?> getQuestionByQuiz(@PathVariable Long qId){
//        return ResponseEntity.ok(this.questionService.getQuestionByQuiz(qId));
//    }

    @GetMapping("/quiz/{qId}")
    public ResponseEntity<?> getQuestionWithNumberOfQuesInQuiz(@PathVariable Long qId){
        return ResponseEntity.ok(this.questionService.getQuestionWithNumberOfQuesInQuiz(qId));
    }

    //getQuestion
    @GetMapping("/{quesId}")
    public ResponseEntity<?> getQuestion(@PathVariable Long quesId){
        return ResponseEntity.ok(this.questionService.getQuestion(quesId));
    }

    //deleteQuestion
    @DeleteMapping("/{quesId}")
    public void deleteQuestion(@PathVariable Long quesId){
        this.questionService.deleteQuestion(quesId);
    }
}
