package com.telusko.quizapp.dao;

import com.telusko.quizapp.models.QuizzesNoOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsNoOptions extends JpaRepository<QuizzesNoOptions, Integer> {

    @Query(value = "SELECT * From quizzes_no_options q ORDER BY RANDOM() LIMIT :numQ ", nativeQuery = true)
    List<QuizzesNoOptions> findRandomQuestions(int numQ);
}
