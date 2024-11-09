package com.aiTech.aispring.service;

import com.aiTech.aispring.entity.Question;
import com.aiTech.aispring.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService implements IService<Question> {

    private final QuestionRepository repo;

    @Override
    public List<Question> retrieveAll() {
        return repo.findAll();
    }

    @Override
    public Question retrieve(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Question add(Question Question) {
        return repo.save(Question);
    }

    @Override
    public void remove(String id) {
        repo.deleteById(id);
    }

    @Override
    public Question modify(Question Question) {
        return repo.save(Question);
    }
}
