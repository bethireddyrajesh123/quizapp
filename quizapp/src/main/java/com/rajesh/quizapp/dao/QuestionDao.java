package com.rajesh.quizapp.dao;

import com.rajesh.quizapp.model.Question;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface QuestionDao extends JpaRepository<Question, Integer> {
      List<Question>findByCategory(String category);

List<Question>findByDifficultyLevel(String difficultyLevel);
    List<Question> findAllByOrderByIdAsc();

    @Query(value="SELECT * from question q WHERE q.category=:category ORDER BY RANDOM() ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, Pageable pageable);
}
