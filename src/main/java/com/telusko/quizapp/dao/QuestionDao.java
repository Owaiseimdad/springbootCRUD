package com.telusko.quizapp.dao;

import com.telusko.quizapp.models.Quizes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Quizes, Integer> {
}
