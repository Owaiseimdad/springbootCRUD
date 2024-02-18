package com.telusko.quizapp.services;

import com.telusko.quizapp.dao.QuestionsNoOptions;
import com.telusko.quizapp.dao.QuizDao;
import com.telusko.quizapp.models.QuestionsWrapper;
import com.telusko.quizapp.models.QuizCreate;
import com.telusko.quizapp.models.Quizes;
import com.telusko.quizapp.models.QuizzesNoOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionsNoOptions questionsNoOptions;
    public ResponseEntity<String> createQuizService(int num_q, String title) {
        List<QuizzesNoOptions> questions = questionsNoOptions.findRandomQuestions(num_q);
        QuizCreate quiz = new QuizCreate();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        String values = String.valueOf(quizDao.findByTitle(quiz.getTitle()).getId());

        return new ResponseEntity<>(values, HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionsWrapper>> getQuizQuestions(int id) {
        Optional<QuizCreate> quiz = quizDao.findById(id);
        List<QuizzesNoOptions> quizQuestion =  quiz.get().getQuestions();
        List<QuestionsWrapper> questionsFinal = new ArrayList<>();

        for (QuizzesNoOptions q:  quizQuestion){
            QuestionsWrapper quizzy = new QuestionsWrapper(q.getId(), q.getQuestion(), null);
            questionsFinal.add(quizzy);
        }

        return new ResponseEntity<>(questionsFinal, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionsWrapper>> getQuizAnswers(int id) {
        Optional<QuizCreate> quiz = quizDao.findById(id);
        List<QuizzesNoOptions> quizQuestion =  quiz.get().getQuestions();
        List<QuestionsWrapper> questionsFinal = new ArrayList<>();

        for (QuizzesNoOptions q:  quizQuestion){
            QuestionsWrapper quizzy = new QuestionsWrapper(q.getId(), q.getQuestion(), q.getUrl());
            questionsFinal.add(quizzy);
        }

        return new ResponseEntity<>(questionsFinal, HttpStatus.OK);
    }
}
