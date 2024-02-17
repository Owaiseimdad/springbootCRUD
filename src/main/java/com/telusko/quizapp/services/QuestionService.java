package com.telusko.quizapp.services;

import com.telusko.quizapp.dao.QuestionDao;
import com.telusko.quizapp.dao.QuestionsNoOptions;
import com.telusko.quizapp.models.Quizes;
import com.telusko.quizapp.models.QuizzesNoOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    QuestionsNoOptions questionNoOptions;

    public ResponseEntity<List<Quizes>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception err){
            err.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Quizes>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByQuestionType(category), HttpStatus.OK);
        }catch (Exception err){
            err.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Quizes question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<String>("success", HttpStatus.CREATED);
        }catch (Exception err){
            err.printStackTrace();
        }

        return new ResponseEntity<String>("Error Faced...", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuizzesNoOptions>> getAllQuestionsNoOptions() {
        try {
            return new ResponseEntity<>(questionNoOptions.findAll(), HttpStatus.OK);
        }catch (Exception err){
            err.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
