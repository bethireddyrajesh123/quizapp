package com.rajesh.quizapp.service;

import com.rajesh.quizapp.model.Question;
import com.rajesh.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService  {
    @Autowired
     QuestionDao questionDao;
    public List<Question> getAllQuestions(){
        return questionDao.findAllByOrderByIdAsc();
    }
    public List<Question> getQuestionsByCategory(String category){
        return questionDao.findByCategory(category);
    }
    public String addQuestion(Question question){
        questionDao.save(question);
        return "Question added Successfully";
    }

    public Optional<Question> getQuestionById(int id) {
        return questionDao.findById(id);
    }

    public List<Question> getQuestionsByDifficulty(String difficultyLevel) {
        return questionDao.findByDifficultyLevel(difficultyLevel);
    }

    public Question updateQuestion(Question question, int id) {
        Question question1= questionDao.findById(id).orElseThrow(() -> new RuntimeException("not found with this id "+ id));

        question1.setQuestionTitle(question.getQuestionTitle());
        question1.setOption1(question.getOption1());
        question1.setOption2(question.getOption2());
        question1.setOption3(question.getOption3());
        question1.setOption4(question.getOption4());
        question1.setRightAnswer(question.getRightAnswer());
        question1.setDifficultyLevel(question.getDifficultyLevel());
        question1.setCategory(question.getCategory());
        return questionDao.save(question1);
    }
}
