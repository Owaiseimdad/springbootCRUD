package com.telusko.quizapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Quizes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String quiz_id;
    private String question;
    private String formattedQuestion;
    private String questionType;
}
