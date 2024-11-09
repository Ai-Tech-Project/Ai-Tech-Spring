package com.aiTech.aispring.controller;


import com.aiTech.aispring.entity.Question;
import com.aiTech.aispring.service.AiService;
import com.aiTech.aispring.service.IService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Question")
public class QuestionController {

  private AiService aiService;
    public IService<Question> QuestionService;


    // http://localhost:8081/projet/Question/retrieve-all-Questions
    @Operation(description = "Ce web service permet de récupérer toutes les Questions de la base de données")
    @GetMapping("/retrieve-all-Questions")
    public List<Question> getQuestions() {
        List<Question> listQuestions = QuestionService.retrieveAll();

        return listQuestions;
    }

    // http://localhost:8081/projet/Question/retrieve-Question/8
    @GetMapping("/retrieve-Question/{Question-id}")
    public Question retrieveQuestion(@PathVariable("Question-id") String id) {
        Question Question = QuestionService.retrieve(id);
        return Question;
    }

    // http://localhost:8081/projet/Question/add-Question
    @PostMapping("/add-Question")
    public Question addQuestion(@RequestBody Question q) {
        Mono<String> answer = aiService.predictChat(q);
        q.setAnswer_text(answer.block());
        Question Question = QuestionService.add(q);
        return Question;
    }

    // http://localhost:8081/projet/Question/remove-Question/{Question-id}
    @DeleteMapping("/remove-Question/{Question-id}")
    public void removeQuestion(@PathVariable("Question-id") String id) {
        QuestionService.remove(id);
    }

    // http://localhost:8081/projet/Question/modify-Question
    @PutMapping("/modify-Question")
    public Question modifyQuestion(@RequestBody Question c) {
        Question Question = QuestionService.modify(c);
        return Question;
    }
}

