package com.telusko.quizapp.controller;

import com.telusko.quizapp.models.Quizes;
import com.telusko.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping("allQuestions")
    public List<Quizes> Questions(){
        return questionService.getAllQuestions();
    }
}
