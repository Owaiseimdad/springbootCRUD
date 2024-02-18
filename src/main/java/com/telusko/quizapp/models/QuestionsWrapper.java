package com.telusko.quizapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Optional;


@Data
@Entity
public class QuestionsWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;
    private String answer;

    public QuestionsWrapper(Integer id, String question, String params) {
        this.id = id;
        this.question = question;
        if(params!=null) {
            this.answer = params;
        }
    }
}
