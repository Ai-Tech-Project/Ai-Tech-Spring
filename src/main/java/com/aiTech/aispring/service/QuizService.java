package com.aiTech.aispring.service;

import com.aiTech.aispring.entity.Quiz;
import com.aiTech.aispring.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuizService implements IService<Quiz> {

    private final QuizRepository repo;

    @Override
    public List<Quiz> retrieveAll() {
        return repo.findAll();
    }

    @Override
    public Quiz retrieve(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Quiz add(Quiz quiz) {
        return repo.save(quiz);
    }

    @Override
    public void remove(String id) {
        repo.deleteById(id);
    }

    @Override
    public Quiz modify(Quiz quiz) {
        return repo.save(quiz);
    }
}
