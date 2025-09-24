package com.rajesh.quizapp.controller;
import com.rajesh.quizapp.model.Question;
import com.rajesh.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {


    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();

    }
    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @GetMapping("getbyid/{id}")
    public  Optional<Question>   getQuestionById(@PathVariable int id){
        return  questionService.getQuestionById(id);
    }

    @GetMapping("difficulty/{difficulty}")
    public List<Question> getQuestionsByDifficulty(@PathVariable("difficulty") String difficultyLevel){
        return questionService.getQuestionsByDifficulty(difficultyLevel);
    }

    @PostMapping("update/{id}")
    public Question updateQuestion(@RequestBody Question question, @PathVariable int id){
        return questionService.updateQuestion(question,id);
    }
}
