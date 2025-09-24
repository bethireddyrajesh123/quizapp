package com.rajesh.quizapp.dao;

import com.rajesh.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizDao extends JpaRepository<Quiz,Integer >{


}
