package com.telusko.quizapp.services;

import com.telusko.quizapp.dao.QuestionDao;
import com.telusko.quizapp.models.Quizes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Quizes> getAllQuestions() {
       return questionDao.findAll();
    }
}
