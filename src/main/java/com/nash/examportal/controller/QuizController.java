package com.nash.examportal.controller;

import com.nash.examportal.model.Quiz;
import com.nash.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    QuizService quizService;

    //addQuiz
    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //updateQuiz
    @PutMapping("/")
    public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //getAllQuiz
    @GetMapping("/")
    public ResponseEntity<?> getAllQuiz(){
        return ResponseEntity.ok(this.quizService.getAllQuiz());
    }

    //getQuiz
    @GetMapping("/{qId}")
    public ResponseEntity<?> getQuiz(@PathVariable("qId") Long qId){
        return ResponseEntity.ok(this.quizService.getQuiz(qId));
    }

    @GetMapping("/category/{cId}")
    public ResponseEntity<?> getQuizByCategory(@PathVariable("cId") Long cId){
        return ResponseEntity.ok(this.quizService.getQuizByCategory(cId));
    }

    @GetMapping("/active")
    public ResponseEntity<?> getQuizByActive(){
        return ResponseEntity.ok(this.quizService.getQuizByActive());
    }

    @GetMapping("/active/category/{cId}")
    public ResponseEntity<?> getQuizByCategoryAndActive(@PathVariable("cId") Long cId){
        return ResponseEntity.ok(this.quizService.getQuizByCategoryAndActive(cId));
    }

    //deleteQuiz
    @DeleteMapping("/{qId}")
    public void deleteQuiz(@PathVariable("qId") Long qId){
        this.quizService.deleteQuiz(qId);
    }
}
