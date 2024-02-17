package com.telusko.quizapp.controller;

import com.telusko.quizapp.dao.QuestionsNoOptions;
import com.telusko.quizapp.models.QuestionsWrapper;
import com.telusko.quizapp.models.QuizCreate;
import com.telusko.quizapp.models.Quizes;
import com.telusko.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam int num_q, @RequestParam String title){
         return quizService.createQuizService(num_q, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionsWrapper>> getQuiz(@PathVariable int id){
        System.out.println(id);
        return quizService.getQuizQuestions(id);
    }
}
