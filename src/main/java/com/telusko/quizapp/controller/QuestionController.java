package com.telusko.quizapp.controller;

import com.telusko.quizapp.models.Quizes;
import com.telusko.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Quizes> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Quizes> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Quizes question){
        return questionService.addQuestion(question);
    }

}
