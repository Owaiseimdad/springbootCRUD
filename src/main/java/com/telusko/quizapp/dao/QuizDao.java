package com.telusko.quizapp.dao;

import com.telusko.quizapp.models.QuizCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<QuizCreate, Integer> {

    @Query(value = "SELECT * From quiz_create where quiz_create.title = :title ", nativeQuery = true)
    QuizCreate findByTitle(String title);
}
