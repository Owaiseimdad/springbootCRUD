package com.telusko.quizapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class QuizzesNoOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    private String question;
    private String answer;
}
