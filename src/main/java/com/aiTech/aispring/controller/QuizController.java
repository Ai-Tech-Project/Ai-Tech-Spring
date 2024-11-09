package com.aiTech.aispring.controller;


import com.aiTech.aispring.entity.Quiz;
import com.aiTech.aispring.service.IService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Quiz")
public class QuizController {


    public IService<Quiz> QuizService;


    // http://localhost:8081/projet/Quiz/retrieve-all-Quizs
    @Operation(description = "Ce web service permet de récupérer toutes les Quizs de la base de données")
    @GetMapping("/retrieve-all-Quizs")
    public List<Quiz> getQuizs() {
        List<Quiz> listQuizs = QuizService.retrieveAll();

        return listQuizs;
    }

    // http://localhost:8081/projet/Quiz/retrieve-Quiz/8
    @GetMapping("/retrieve-Quiz/{Quiz-id}")
    public Quiz retrieveQuiz(@PathVariable("Quiz-id") String id) {
        Quiz Quiz = QuizService.retrieve(id);
        return Quiz;
    }

    // http://localhost:8081/projet/Quiz/add-Quiz
    @PostMapping("/add-Quiz")
    public Quiz addQuiz(@RequestBody Quiz c) {
        Quiz Quiz = QuizService.add(c);
        return Quiz;
    }

    // http://localhost:8081/projet/Quiz/remove-Quiz/{Quiz-id}
    @DeleteMapping("/remove-Quiz/{Quiz-id}")
    public void removeQuiz(@PathVariable("Quiz-id") String id) {
        QuizService.remove(id);
    }

    // http://localhost:8081/projet/Quiz/modify-Quiz
    @PutMapping("/modify-Quiz")
    public Quiz modifyQuiz(@RequestBody Quiz c) {
        Quiz Quiz = QuizService.modify(c);
        return Quiz;
    }
}

