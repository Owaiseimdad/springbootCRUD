package com.telusko.quizapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Quizes {

    @Id
    private String quiz_id;
    private String question;
    private String formattedQuestion;
}
